/*******************************************************************************
 * This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Peter Smith
 *******************************************************************************/
package org.boris.winrun4j.test.unit;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.boris.commons.io.ProcessResult;
import org.boris.winrun4j.Launcher;
import org.boris.winrun4j.winapi.DDEML;

public class FileAssociationsTest
{
    public void testBasic() throws Exception {
        Launcher l = new Launcher()
                .main(FileAssociationsTest.class)
                .classpath(new File("."))
                .arg("-test")
                .arg("-hello")
                .dde(true, DDEML.class)
                .fileAss(".fte", "File Association Test", "Testing file assocations")
                .fileAss(".ft2", "File Association Test 2", "Testing file assocations");
        ProcessResult pr = l.launch("--WinRun4J:RegisterFileAssociations");
        pr.waitFor();
        String result = pr.toString();
        assertTrue(result.contains("[info] Registering .fte"));
        assertTrue(result.contains("[info] Registering .ft2"));
    }
}
