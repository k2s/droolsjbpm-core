/*
 * Copyright (c) 2013. Alexander Herwix
 * This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * You can also obtain a commercial license. Contact: alex@herwix.com for further details.
 */

package com.iterranux.droolsjbpmCore.runtime.manager.impl;

import com.iterranux.droolsjbpmCore.runtime.manager.api.RuntimeManagerFactory;
import org.jbpm.runtime.manager.impl.PerProcessInstanceRuntimeManager;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.runtime.manager.RuntimeEnvironment;
import org.kie.internal.runtime.manager.SessionFactory;
import org.kie.internal.runtime.manager.TaskServiceFactory;
import org.springframework.stereotype.Component;

@Component
public class PerProcessInstanceRuntimeManagerFactory implements RuntimeManagerFactory {

    public final static String RUNTIME_MANAGER_TYPE = "PER_PROCESS_INSTANCE";

    @Override
    public RuntimeManager newRuntimeManager(RuntimeEnvironment environment, SessionFactory factory, TaskServiceFactory taskServiceFactory, String identifier) {
        return new PerProcessInstanceRuntimeManager(environment, factory, taskServiceFactory, identifier);
    }

    @Override
    public String getManufacturableTypeName() {
        return RUNTIME_MANAGER_TYPE;
    }
}
