package com.ejobim.opplat.util;

import com.ejobim.opplat.domain.bean.CodeModel;
import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class QR_Code {
    private static int BLACK = 0x000000;
    private static int WHITE = 0xFFFFFF;

    /**
     * 1.创建最原始的二维码图片
     *
     * @param info
     * @return
     */
    private BufferedImage createCodeImage(CodeModel info) {

        String contents = info.getContents();//获取正文
        int width = info.getWidth();//宽度
        int height = info.getHeight();//高度
        Map<EncodeHintType, Object> hint = new HashMap<>();
        hint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);//设置二维码的纠错级别【级别分别为M L H Q ，H纠错能力级别最高，约可纠错30%的数据码字】
        hint.put(EncodeHintType.CHARACTER_SET, info.getCharacter_set());//设置二维码编码方式【UTF-8】
        hint.put(EncodeHintType.MARGIN, 0);

        MultiFormatWriter writer = new MultiFormatWriter();
        BufferedImage img = null;
        try {
            //构建二维码图片
            //QR_CODE 一种矩阵二维码
            BitMatrix bm = writer.encode(contents, BarcodeFormat.QR_CODE, width, height + 5, hint);

            int[] locationTopLeft = bm.getTopLeftOnBit();
            int[] locationBottomRight = bm.getBottomRightOnBit();
            info.setBottomStart(new int[] { locationTopLeft[0], locationBottomRight[1] });
            info.setBottomEnd(locationBottomRight);
            int w = bm.getWidth();
            int h = bm.getHeight();
            img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < w; x++) {
                for (int y = 0; y < h; y++) {
                    img.setRGB(x, y, bm.get(x, y) ? BLACK : WHITE);
                }
            }
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return img;
    }

    /**
     * 2.为二维码增加logo和二维码下文字 logo--可以为null 文字--可以为null或者空字符串""
     *
     * @param info
     * @param output
     */
    public BufferedImage dealLogoAndDesc(CodeModel info, OutputStream output) {
        //获取原始二维码图片
        BufferedImage bm = createCodeImage(info);
        //获取Logo图片
        File logoFile = info.getLogoFile();
        int width = bm.getWidth();
        int height = bm.getHeight();
        Graphics g = bm.getGraphics();

        //处理logo
        if (logoFile != null && logoFile.exists()) {
            try {
                BufferedImage logoImg = ImageIO.read(logoFile);
                int logoWidth = logoImg.getWidth();
                int logoHeight = logoImg.getHeight();
                float ratio = info.getLogoRatio();//获取Logo所占二维码比例大小
                if (ratio > 0) {
                    logoWidth = logoWidth > width * ratio ? (int) (width * ratio) : logoWidth;
                    logoHeight = logoHeight > height * ratio ? (int) (height * ratio) : logoHeight;
                }
                int x = (width - logoWidth) / 2;
                int y = (height - logoHeight) / 2;
                //根据logo 起始位置 和 宽高 在二维码图片上画出logo
                g.drawImage(logoImg, x, y, logoWidth, logoHeight, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //处理二维码下文字
        String desc = info.getDesc();
        if (!"".equals(desc)) {
            try {
                //设置文字字体
                int whiteWidth = info.getHeight() - info.getBottomEnd()[1];
                Font font = new Font("宋体", Font.PLAIN, info.getFontSize());
                int fontHeight = g.getFontMetrics(font).getHeight();
                //计算需要多少行
                int lineNum = 1;
                int currentLineLen = 0;
                for (int i = 0; i < desc.length(); i++) {
                    char c = desc.charAt(i);
                    int charWidth = g.getFontMetrics(font).charWidth(c);
                    if (currentLineLen + charWidth > width) {
                        lineNum++;
                        currentLineLen = 0;
                        continue;
                    }
                    currentLineLen += charWidth;
                }
                int totalFontHeight = fontHeight * lineNum;
                int wordTopMargin = 4;
                BufferedImage bm1 = new BufferedImage(width, height + totalFontHeight + wordTopMargin - whiteWidth,
                        BufferedImage.TYPE_INT_RGB);
                Graphics g1 = bm1.getGraphics();
                if (totalFontHeight + wordTopMargin - whiteWidth > 0) {
                    g1.setColor(Color.WHITE);
                    g1.fillRect(0, height, width, totalFontHeight + wordTopMargin - whiteWidth);
                }
                g1.setColor(new Color(BLACK));
                g1.setFont(font);
                int startX = (78 - (12 * desc.length())) / 2;
                g1.drawImage(bm, 0, 0, null);
                width = info.getBottomEnd()[0] - info.getBottomStart()[0];
                height = info.getBottomEnd()[1] + 1;
                currentLineLen = 0;
                int currentLineIndex = 0;
                int baseLo = g1.getFontMetrics().getAscent();
                for (int i = 0; i < desc.length(); i++) {
                    String c = desc.substring(i, i + 1);
                    int charWidth = g.getFontMetrics(font).stringWidth(c);
                    if (currentLineLen + charWidth > width) {
                        currentLineIndex++;
                        currentLineLen = 0;
                        g1.drawString(c, currentLineLen + startX - 5,
                                -5 + height + baseLo + fontHeight * (currentLineIndex) + wordTopMargin);
                        currentLineLen = charWidth;
                        continue;
                    }
                    g1.drawString(c, currentLineLen + startX - 5,
                            -5 + height + baseLo + fontHeight * (currentLineIndex) + wordTopMargin);
                    currentLineLen += charWidth;
                }
//                //处理二维码下日期
//                String date = info.getDate();
//                g1.drawString(date, 5, 6 + height + baseLo + fontHeight * (currentLineIndex) + wordTopMargin);
//                g1.dispose();
                bm = bm1;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
           //ImageIO.write(bm, info.getFormat(), output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bm;
    }
    /**
     * 2.为二维码增加logo和二维码下文字 logo--可以为null 文字--可以为null或者空字符串""
     *
     * @param info
     */
    public BufferedImage dealLogoAndPic(CodeModel info) {
        //获取原始二维码图片
        BufferedImage bm = createCodeImage(info);
//        //获取Logo图片
//       // File logoFile = info.getLogoFile();
//        int width = bm.getWidth();
//        int height = bm.getHeight();
//        Graphics g = bm.getGraphics();

        //处理logo
       /* if (logoFile != null && logoFile.exists()) {
            try {
                BufferedImage logoImg = ImageIO.read(logoFile);
                int logoWidth = logoImg.getWidth();
                int logoHeight = logoImg.getHeight();
                float ratio = info.getLogoRatio();//获取Logo所占二维码比例大小
                if (ratio > 0) {
                    logoWidth = logoWidth > width * ratio ? (int) (width * ratio) : logoWidth;
                    logoHeight = logoHeight > height * ratio ? (int) (height * ratio) : logoHeight;
                }
                int x = (width - logoWidth) / 2;
                int y = (height - logoHeight) / 2;
                //根据logo 起始位置 和 宽高 在二维码图片上画出logo
                g.drawImage(logoImg, x, y, logoWidth, logoHeight, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
*/
//        //处理二维码下文字
//        String desc = info.getDesc();
//        if (!"".equals(desc)) {
//            try {
//                //设置文字字体
//                int whiteWidth = info.getHeight() - info.getBottomEnd()[1];
//                Font font = new Font("宋体", Font.PLAIN, info.getFontSize());
//                int fontHeight = g.getFontMetrics(font).getHeight();
//                //计算需要多少行
//                int lineNum = 1;
//                int currentLineLen = 0;
//                for (int i = 0; i < desc.length(); i++) {
//                    char c = desc.charAt(i);
//                    int charWidth = g.getFontMetrics(font).charWidth(c);
//                    if (currentLineLen + charWidth > width) {
//                        lineNum++;
//                        currentLineLen = 0;
//                        continue;
//                    }
//                    currentLineLen += charWidth;
//                }
//                int totalFontHeight = fontHeight * lineNum;
//                int wordTopMargin = 4;
//                BufferedImage bm1 = new BufferedImage(width, height + totalFontHeight + wordTopMargin - whiteWidth,
//                        BufferedImage.TYPE_INT_RGB);
//                Graphics g1 = bm1.getGraphics();
//                if (totalFontHeight + wordTopMargin - whiteWidth > 0) {
//                    g1.setColor(Color.WHITE);
//                    g1.fillRect(0, height, width, totalFontHeight + wordTopMargin - whiteWidth);
//                }
//                g1.setColor(new Color(BLACK));
//                g1.setFont(font);
//                int startX = (78 - (12 * desc.length())) / 2;
//                g1.drawImage(bm, 0, 0, null);
//                width = info.getBottomEnd()[0] - info.getBottomStart()[0];
//                height = info.getBottomEnd()[1] + 1;
//                currentLineLen = 0;
//                int currentLineIndex = 0;
//                int baseLo = g1.getFontMetrics().getAscent();
//                for (int i = 0; i < desc.length(); i++) {
//                    String c = desc.substring(i, i + 1);
//                    int charWidth = g.getFontMetrics(font).stringWidth(c);
//                    if (currentLineLen + charWidth > width) {
//                        currentLineIndex++;
//                        currentLineLen = 0;
//                        g1.drawString(c, currentLineLen - 5,
//                                -5 + height + fontHeight * (currentLineIndex) + wordTopMargin);
//                        currentLineLen = charWidth;
//                        continue;
//                    }
//                   /* g1.drawString(c, currentLineLen + startX - 5,
//                            -5 + height + baseLo + fontHeight * (currentLineIndex) + wordTopMargin);*/
//                    g1.drawString(c,  (width - 20 * desc.length()) / 2 + 20 * i,
//                            15);
//                    currentLineLen += charWidth;
//                }
//                //处理二维码下日期
//                //String date = info.getDate();
//                //g1.drawString("123123132", 5, 6 + height + baseLo + fontHeight * (currentLineIndex) + wordTopMargin);
//                g1.dispose();
//                bm = bm1;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        return bm;
    }
    /**
     * 3.创建 带logo和文字的二维码
     *
     * @param info
     * @param file
     */
    public void createCodeImage(CodeModel info, File file) {
        File parent = file.getParentFile();
        if (!parent.exists())
            parent.mkdirs();
        OutputStream output = null;
        try {
            output = new BufferedOutputStream(new FileOutputStream(file));
            dealLogoAndDesc(info, output);
            output.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 3.创建 带logo和文字的二维码
     *
     * @param info
     * @param filePath
     */
    public void createCodeImage(CodeModel info, String filePath) {
        createCodeImage(info, new File(filePath));
    }

    /**
     * 4.创建 带logo和文字的二维码
     *
     * @param filePath
     */
    public void createCodeImage(String contents, String filePath) {
        CodeModel codeModel = new CodeModel();
        codeModel.setContents(contents);
        createCodeImage(codeModel, new File(filePath));
    }

    /**
     * 5.读取 二维码 获取二维码中正文
     *
     * @param input
     * @return
     */
    public String decode(InputStream input) {
        Map<DecodeHintType, Object> hint = new HashMap<DecodeHintType, Object>();
        hint.put(DecodeHintType.POSSIBLE_FORMATS, BarcodeFormat.QR_CODE);
        String result = "";
        try {
            BufferedImage img = ImageIO.read(input);
            int[] pixels = img.getRGB(0, 0, img.getWidth(), img.getHeight(), null, 0, img.getWidth());
            LuminanceSource source = new RGBLuminanceSource(img.getWidth(), img.getHeight(), pixels);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            QRCodeReader reader = new QRCodeReader();
            com.google.zxing.Result r = reader.decode(bitmap, hint);
            result = r.getText();
        } catch (Exception e) {
            result = "读取错误";
        }
        return result;
    }

    public static void main(String[] args) {
        String imgname = "1.png";
        CodeModel info = new CodeModel();
        info.setContents("www");
        info.setWidth(240);
        info.setHeight(240);
        info.setFontSize(12);
        //info.setLogoFile(new File("C:\\work\\H5\\img\\logo.png"));
        info.setDesc("设备11");
        info.setDate("");
        QR_Code code = new QR_Code();
        code.createCodeImage(info,"C:\\Users\\wjl\\Desktop\\" + imgname);
    }
}
