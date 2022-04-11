package com.ejobim.opplat.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeUtils {

    protected TreeUtils() {

    }

    public static <T> Tree<T> build(List<Tree<T>> nodes) {
        if (nodes == null) {
            return null;
        }
        List<Tree<T>> topNodes = new ArrayList<>();
        nodes.forEach(children -> {
            String pid = children.getParentId();
            if (pid == null || "0".equals(pid)) {
                topNodes.add(children);
                return;
            }
            for (Tree<T> parent : nodes) {
                String id = parent.getId();
                if (id != null && id.equals(pid)) {
                    parent.getChildren().add(children);
                    children.setHasParent(true);
                    parent.setChildren(true);
                    return;
                }
            }
        });

        Tree<T> root = new Tree<>();
        root.setId("0");
//		root.setLevel("0");
        root.setParentId("");
        //root.setHasParent(false);
        //root.setChildren(true);
        //root.setChecked(true);
        root.setChildren(topNodes);
        root.setText("根节点");
        Map<String, Object> state = new HashMap<>(16);
        state.put("opened", true);
        root.setState(state);
        return root;
    }

    public static <T> List<Tree<T>> buildList(List<Tree<T>> nodes, String idParam) {
        if (nodes == null) {
            return new ArrayList<>();
        }
        List<Tree<T>> topNodes = new ArrayList<>();
        nodes.forEach(children -> {
            String pid = children.getParentId();
            if (pid == null || idParam.equals(pid)) {
                topNodes.add(children);
                return;
            }
            nodes.forEach(parent -> {
                String id = parent.getId();
                if (id != null && id.equals(pid)) {
                    parent.getChildren().add(children);
                    children.setHasParent(true);
                    parent.setChildren(true);
                }
            });
        });
        return topNodes;
    }

   /* public static void buildTrees(List<Tree<TbSynObject>> trees, List<TbSynObject> tbSynObjects) {
        tbSynObjects.forEach(menu -> {
            Tree<TbSynObject> tree = new Tree<>();
            tree.setId(menu.getUri());
            tree.setParentId(menu.getParentUri());
            Map<String, Object> attribute = new HashMap<>();
            attribute.put("type", menu.getType());
            attribute.put("accessLevel", menu.getAccesslevel());
            attribute.put("browseName", menu.getBrowsename());
            attribute.put("factoryNo", menu.getFactoryNo());
            attribute.put("noType", menu.getFieldUri());//设置设备类型
            attribute.put("level", menu.getLevel());
            attribute.put("browsePath", menu.getBrowsepath());
            tree.setAttributes(attribute);
            tree.setText(StringTools.clearNumber(menu.getDisplayname()));
            trees.add(tree);
        });
    }*/

  /*  public static void buildMenuTrees(List<Tree<TbSysMenu>> trees, List<TbSysMenu> menuList) {
        menuList.forEach(menu -> {
            Tree<TbSysMenu> tree = new Tree<>();
            tree.setId(menu.getMenuNo());
            tree.setParentId(menu.getParentId());
            Map<String, Object> attribute = new HashMap<>();
            attribute.put("type", menu.getType());
            attribute.put("sort", menu.getSort());
            attribute.put("perms", menu.getPerms());
            attribute.put("url", menu.getUrl());
            tree.setAttributes(attribute);
            tree.setText(StringTools.clearNumber(menu.getMenuName()));
            trees.add(tree);
        });
    }*/


    /**
     * 剔除空的树节点
     *
     * @param tbSynObjects
     * @param idList
     */
  /*  public static void freshSynData(List<Tree<TbSynObject>> tbSynObjects, List<String> idList) {
        for (int i = tbSynObjects.size() - 1; i >= 0; i--) {
            if (tbSynObjects.get(i).getAttributes().get("type").toString().equals("4")) {
                if (!idList.contains(tbSynObjects.get(i).getId())) {
                    tbSynObjects.remove(tbSynObjects.get(i));
                }
            } else {
                freshSynData(tbSynObjects.get(i).getChildren(), idList);
                if (tbSynObjects.get(i).getChildren().size() == 0) {
                    tbSynObjects.remove(tbSynObjects.get(i));
                }
            }
        }
    }*/

    /**
     * 修改树的参差结构保证最多3层
     *
     * @param tbSynObjects
     */
   /* public static void changeTreeLevel(List<Tree<TbSynObject>> tbSynObjects) {
        for (int i = 0; i < tbSynObjects.size(); i++) {
            Tree<TbSynObject> treNode = tbSynObjects.get(i);
            int levelCount = getLevelCount(treNode);
            if(levelCount>3) {
				levelCount = levelCount > 3 ? 3 : levelCount;
			}
			composeTreeNode(treNode, 1, levelCount);


        }
    }


    private static List<Tree<TbSynObject>> composeTreeNode(Tree<TbSynObject> treeNode, int currentLevel, int maxLevel) {
        List<Tree<TbSynObject>> list = new ArrayList<>();
        for (int i = treeNode.getChildren().size() - 1; i >= 0; i--) {
            Tree<TbSynObject> node = treeNode.getChildren().get(i);
            if (!node.getAttributes().get("type").toString().equals("4")) {
                boolean hasLeaf = hasLeafNode(node.getChildren());
                List<Tree<TbSynObject>> childList = composeTreeNode(node, currentLevel + 1, maxLevel);
                if (currentLevel == maxLevel - 1) {
					if (!hasLeaf) {
						treeNode.getChildren().remove(i);
					}else{
						node.getAttributes().put("added",true);
					}
                    for (Tree<TbSynObject> cNode : childList) {
                        cNode.setText(node.getText() + "/" + cNode.getText());
						treeNode.getChildren().add(cNode);
                    }

                } else if (currentLevel >= maxLevel) {
					treeNode.getChildren().remove(i);
					if (hasLeaf) {
						node.getAttributes().put("added",true);
						list.add(0,node);
					}
					for (Tree<TbSynObject> cNode : childList) {
						cNode.setText(node.getText() + "/" + cNode.getText());
						list.add(cNode);
					}

                }else{
					if(hasLeaf){
						node.getAttributes().put("added",true);
					}
				}
            }
        }
        return list;
    }

    *//**
     * 判断树节点是否有叶子节点
     *
     * @return
     *//*
    private static boolean hasLeafNode(List<Tree<TbSynObject>> nodes) {
        for (Tree<TbSynObject> node : nodes) {
            if (node.getAttributes().get("type").toString().equals("4")) {
                return true;
            }
        }
        return false;
    }

    private static int getLevelCount(Tree<TbSynObject> treeNode) {
        int levelCount = Integer.MAX_VALUE;
        for (int i = 0; i < treeNode.getChildren().size(); i++) {
            if (treeNode.getChildren().get(i).getAttributes().get("type").toString().equals("4")) {
                return 1;
            } else {
                int currentLevel = getLevelCount(treeNode.getChildren().get(i));
                if (currentLevel < levelCount) {
                    levelCount = currentLevel;
                }
            }
        }
        return levelCount + 1;

    }


    *//**
     * 剔除空的树节点
     *
     * @param tbSynObjects
     * @param idList
     *//*
    public static void freshSynDataParent(List<Tree<TbSynObject>> tbSynObjects, List<String> idList) {


        for (int i = tbSynObjects.size() - 1; i >= 0; i--) {
            Tree<TbSynObject> treeNode = tbSynObjects.get(i);
            if (treeNode.getChildren().size() > 0) {
                freshSynDataParent(treeNode.getChildren(), idList);
                if (treeNode.getChildren().size() == 0) {
                    if (!idList.contains(treeNode.getId())) {
                        tbSynObjects.remove(treeNode);
                    }

                }
            } else {
                if (!idList.contains(treeNode.getId())) {
                    tbSynObjects.remove(treeNode);
                }
            }
        }

    }

    *//**
     * 剔除空的树节点
     *
     * @param tbSynObjects
     *//*
    public static void addTreeNode(List<Tree<TbSynObject>> tbSynObjects, List<TbFillFormField> list) {
        for (int i = tbSynObjects.size() - 1; i >= 0; i--) {
            Tree<TbSynObject> treeNode = tbSynObjects.get(i);
            for (TbFillFormField fillFormField : list) {
                if (treeNode.getId().equals(fillFormField.getEquipNo())) {
                    Tree<TbSynObject> chideNode = getTreeNode(fillFormField);
                    treeNode.getChildren().add(chideNode);
                }
            }
            if (treeNode.getChildren().size() > 0) {
                addTreeNode(treeNode.getChildren(), list);
            }
        }
    }

    public static void clearSpaceNode(List<Tree<TbSynObject>> tbSynObjects) {
        for (int i = tbSynObjects.size() - 1; i >= 0; i--) {
            Tree<TbSynObject> treeNode = tbSynObjects.get(i);
            if (treeNode.getText().equals("送水系统")) {
                System.out.println(treeNode.getText() + "|" + treeNode.getChildren().size());
            }
            if (!"4".equals(treeNode.getAttributes().get("type").toString())) {
                if (treeNode.getChildren().size() > 0) {
                    clearSpaceNode(treeNode.getChildren());
                    if (treeNode.getChildren().size() == 0) {
                        tbSynObjects.remove(treeNode);
                    }
                } else
                    tbSynObjects.remove(treeNode);
            }

        }

    }

    private static Tree<TbSynObject> getTreeNode(TbFillFormField fillFormField) {
        Tree<TbSynObject> tree = new Tree<>();
        tree.setId(fillFormField.getConfigNo());
        tree.setParentId(fillFormField.getEquipNo());
        Map<String, Object> attribute = new HashMap<>();
        attribute.put("type", 4);
        attribute.put("accessLevel", fillFormField.getFieldUnit());
        attribute.put("browseName", fillFormField.getFieldCode());
        attribute.put("factoryNo", fillFormField.getFactoryNo());
        //设置设备类型
        attribute.put("noType", fillFormField.getFillType());
        attribute.put("level", 4);
        attribute.put("browsePath", fillFormField.getBrowsePath());
        tree.setAttributes(attribute);
        tree.setText(StringTools.clearNumber(fillFormField.getSedName()));
        return tree;
    }

    public static List<TbSysMenu> getMenuList(List<TbSysMenu> sysMenus) {
        List<TbSysMenu> topMenuList = new ArrayList<>();
        Map<String, List<TbSysMenu>> chileMap = new HashMap<>();
        for (TbSysMenu tbSysMenu : sysMenus) {
            if ("0".equals(tbSysMenu.getParentId())) {
                topMenuList.add(tbSysMenu);
            } else {
                if (!chileMap.containsKey(tbSysMenu.getParentId())) {
                    List<TbSysMenu> list = new ArrayList<>();
                    chileMap.put(tbSysMenu.getParentId(), list);
                }
                chileMap.get(tbSysMenu.getParentId()).add(tbSysMenu);
            }
        }
        for (TbSysMenu tbSysMenu : sysMenus) {
            if (chileMap.containsKey(tbSysMenu.getMenuNo())) {
                tbSysMenu.setChildren(chileMap.get(tbSysMenu.getMenuNo()));
            }
        }
        return topMenuList;
    }
*/

}