/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2013-2015 Denis Forveille (titou10.titou10@gmail.com)
 * Copyright (C) 2010-2023 DBeaver Corp and others
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jkiss.dbeaver.ext.db2.ui.tools.maintenance;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.ui.handlers.HandlerUtil;
import org.jkiss.dbeaver.ext.db2.model.DB2Table;
import org.jkiss.dbeaver.model.struct.DBSObject;
import org.jkiss.dbeaver.ui.navigator.NavigatorUtils;
import org.jkiss.utils.CommonUtils;

import java.util.List;

/**
 * DB2 table reorg action
 */
public class DB2ReorgTableToolCommandHandler extends AbstractHandler {
    @Override
    public Object execute(ExecutionEvent event) {
        List<DBSObject> selectedObjects = NavigatorUtils.getSelectedObjects(HandlerUtil.getCurrentSelection(event));
        List<DB2Table> tables = CommonUtils.filterCollection(selectedObjects, DB2Table.class);
        if (!tables.isEmpty()) {
            DB2ReorgTableDialog dialog = new DB2ReorgTableDialog(HandlerUtil.getActivePart(event).getSite(), tables);
            return dialog.open();
        }
        return null;
    }
}
