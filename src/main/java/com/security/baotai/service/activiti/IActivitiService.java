package com.security.baotai.service.activiti;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public interface IActivitiService {

    void startProcess(String processDefinitionKey, Map<String, Object> variables);

    void startProcess(String processDefinitionKey, String businessKey, Map<String, Object> variables);

    List<Task> getTasks(String processDefinitionKey, String userId);

    List<Task> getTasks(String processDefinitionKey, String businessKey, String userId);

    ProcessInstance getProcessInstance(String processInstanceId);

    Map<String, ProcessInstance> getProcessInstances(Set<String> processInstanceIds);

    void completeTask(String taskId, Map<String, Object> variables);
}
