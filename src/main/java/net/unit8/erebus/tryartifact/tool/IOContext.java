package net.unit8.erebus.tryartifact.tool;

/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

import java.io.IOException;

/**
 * Interface for defining user interaction with the shell.
 * @author Robert Field
 * @author kawasima
 */
abstract class IOContext implements AutoCloseable {

    @Override
    public abstract void close() throws IOException;

    public abstract String readLine(String prompt, String prefix) throws IOException, InputInterruptedException;

    public abstract boolean interactiveOutput();

    public abstract Iterable<String> currentSessionHistory();

    public abstract  boolean terminalEditorRunning();

    public abstract void suspend();

    public abstract void resume();

    public abstract void beforeUserCode();

    public abstract void afterUserCode();

    public abstract void replaceLastHistoryEntry(String source);

    class InputInterruptedException extends Exception {
        private static final long serialVersionUID = 1L;
    }
}
