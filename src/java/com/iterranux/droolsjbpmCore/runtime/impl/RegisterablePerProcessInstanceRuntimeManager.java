package com.iterranux.droolsjbpmCore.runtime.impl;


import com.iterranux.droolsjbpmCore.runtime.api.RegisterableRuntimeManager;
import org.jbpm.runtime.manager.impl.PerProcessInstanceRuntimeManager;
import org.kie.internal.runtime.manager.RuntimeEnvironment;
import org.kie.internal.runtime.manager.SessionFactory;
import org.kie.internal.runtime.manager.TaskServiceFactory;

public class RegisterablePerProcessInstanceRuntimeManager extends PerProcessInstanceRuntimeManager implements RegisterableRuntimeManager{

    public static final String RUNTIME_MANAGER_TYPE = "PER_PROCESS_INSTANCE";

    @Override
    public String getRuntimeManagerType() {
        return RUNTIME_MANAGER_TYPE;
    }

    public RegisterablePerProcessInstanceRuntimeManager(RuntimeEnvironment environment, SessionFactory factory, TaskServiceFactory taskServiceFactory, String identifier){
        super(environment, factory, taskServiceFactory, identifier);
    }
}
