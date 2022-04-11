package com.ejobim.opplat.schedule;

import org.springframework.stereotype.Service;

/**
 * 报表定时服务
 * 定时生成底稿数据、日报数据等
 * @author zch
 */
@Service
public class ReportScheduleService {

   /* private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ReportService reportService;
    
    @Autowired
    private TbFactoryService factoryService;

    @Autowired
    private SchedulingService  schedulingService;
    
    @Value("${report.schedule.enabled}")
    private boolean enabled;

    *//**
     * 日报数据的定时任务
     *//*
    //@Scheduled(cron = "${report.schedule.dateReport.cron}")
    public void scheduleDateReportTask() {
        logger.info("判定服务是否需要启动任务");
        if(!this.enabled) {
            return;
        }
        logger.info("启动日报数据生成任务");

        List<TbFactoryInfo> factories = this.factoryService.getTbFactoryInfoList(new TbFactoryInfo());
        for(TbFactoryInfo factory : factories) {
            this.reportService.insertReportDate(factory.getFactoryNo());
        }
    }
    *//**
     * 一周填报数据的定时任务
     *//*
    @Scheduled(cron = "${report.schedule.mon.cron}")
    public void dayWeekDateReportTask() {
        logger.info("判定服务是否需要启动任务");
        if(!this.enabled) {
            return;
        }
        logger.info("一周填报数据的定时任务");
        List<TbFactoryInfo> factories = this.factoryService.getTbFactoryInfoList(new TbFactoryInfo());
        for(TbFactoryInfo factory : factories) {
            this.reportService.selectReportDayWeekDate(factory.getFactoryNo());
        }
    }

    *//**
     *  一天一次自动排班
     *//*
    @Scheduled(cron = "${report.schedule.schedule.cron}")
    public void schedulePlanTask() {
        logger.info("判定服务是否需要启动任务");
        if(!this.enabled) {
            return;
        }
        logger.info("排班数据的定时任务");
        List<TbFactoryInfo> factories = this.factoryService.getTbFactoryInfoList(new TbFactoryInfo());
        for(TbFactoryInfo factory : factories) {
            schedulingService.addNextWorkSchedule(factory.getFactoryNo());
        }
    }*/

}
