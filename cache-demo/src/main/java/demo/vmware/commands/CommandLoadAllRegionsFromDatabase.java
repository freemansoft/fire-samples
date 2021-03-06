/*
 * Copyright 2011 VMWare.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo.vmware.commands;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;

import demo.vmware.util.DataLoaderUtils;

/**
 * Placeholder for class that loads data from files
 * 
 * @author freemanj
 * 
 */
public class CommandLoadAllRegionsFromDatabase implements ICommand {

    /** loader utils that actually load data and store to the cache */
    private final DataLoaderUtils loaderUtils;

    /** constructor injection is best */
    public CommandLoadAllRegionsFromDatabase(DataLoaderUtils loaderUtils) {
        this.loaderUtils = loaderUtils;
    }

    @Override
    public String commandDescription() {
        return "Load all possible regions from data from DB pre-defined automapping assumes 1-1 mapping.";
    }

    @Override
    public String usageDescription() {
        return "<cmd> ";
    }

    @Override
    public int numberOfParameters() {
        return 0;
    }

    @Override
    public CommandResult run(ConfigurableApplicationContext mainContext, List<String> parameters) {
        // TODO turn off write-behind
        CommandResult result = loaderUtils.loadAllRegionFromDB();
        // TODO turn back on write-behind
        return result;
    }
}
