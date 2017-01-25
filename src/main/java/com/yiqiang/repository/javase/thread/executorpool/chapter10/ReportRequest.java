package com.yiqiang.repository.javase.thread.executorpool.chapter10;

import java.util.concurrent.CompletionService;

/**
 * Title:
 * Description:
 * This class represents every actor that can request a report. For this example,
 * it simply create three ReportGenerator objects and execute them through a
 * CompletionService
 * Create Time: 2017/1/20 0020 2:26
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class ReportRequest implements Runnable {

    /**
     * Name of this ReportRequest
     */
    private String name;

    /**
     * CompletionService used for the execution of the ReportGenerator tasks
     */
    private CompletionService<String> service;

    /**
     * Constructor of the class. Initializes the parameters
     * @param name Name of the ReportRequest
     * @param service Service used for the execution of tasks
     */
    public ReportRequest(String name, CompletionService<String> service){
        this.name=name;
        this.service=service;
    }

    /**
     * Main method of the class. Create three ReportGenerator tasks and executes them
     * through a CompletionService
     */
    @Override
    public void run() {
        ReportGenerator reportGenerator=new ReportGenerator(name, "Report");
        service.submit(reportGenerator);
    }

}
