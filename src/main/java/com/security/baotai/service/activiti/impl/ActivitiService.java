package com.security.baotai.service.activiti.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.baotai.service.activiti.IActivitiService;

@Service
public class ActivitiService implements IActivitiService {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Override
    public void startProcess(String processDefinitionKey, Map<String, Object> variables) {
        runtimeService.startProcessInstanceByKey(processDefinitionKey, variables);
    }

    @Override
    public void startProcess(String processDefinitionKey, String businessKey, Map<String, Object> variables) {
        runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey, variables);
    }

    @Override
    public List<Task> getTasks(String processDefinitionKey, String businessKey, String userId) {

        return taskService.createTaskQuery().taskAssignee(userId).processDefinitionKey(processDefinitionKey).processInstanceBusinessKey(businessKey)
                .orderByTaskCreateTime().asc().list();
    }

    @Override
    public List<Task> getTasks(String processDefinitionKey, String userId) {
        return taskService.createTaskQuery().taskAssignee(userId).processDefinitionKey(processDefinitionKey).orderByTaskCreateTime().asc().list();
    }

    @Override
    public ProcessInstance getProcessInstance(String processInstanceId) {
        return runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId)
                .singleResult();
    }

    @Override
    public Map<String, ProcessInstance> getProcessInstances(Set<String> processInstanceIds) {
        List<ProcessInstance> processInstanceList = runtimeService.createProcessInstanceQuery().processInstanceIds(processInstanceIds).list();
        if (CollectionUtils.isNotEmpty(processInstanceList)) {
            Map<String, ProcessInstance> processInstanceMap = new HashMap<String, ProcessInstance>();
            for (ProcessInstance pi : processInstanceList) {
                processInstanceMap.put(pi.getProcessInstanceId(), pi);
            }
            return processInstanceMap;
        }
        return null;
    }

    @Override
    public void completeTask(String taskId, Map<String, Object> variables) {
        taskService.complete(taskId, variables);
    }

}
