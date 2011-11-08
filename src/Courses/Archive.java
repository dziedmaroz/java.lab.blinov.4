/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Courses;

import java.util.Arrays;

/**
 *
 * @author lucian
 */
public class Archive
{
    private ArhciveEntry[] arhciveEntries;
    private int entriesCount;
    public Archive()
    {
        arhciveEntries = new ArhciveEntry[50] ;
        entriesCount = 0;
    }

    public void addArchiveEntry (ArhciveEntry entry)
    {
        if (entriesCount==arhciveEntries.length)
        {
            ArhciveEntry [] tmp = Arrays.copyOf(arhciveEntries, entriesCount+50);
            arhciveEntries = Arrays.copyOf(tmp, entriesCount+50);
        }

        arhciveEntries[entriesCount]=entry;
        entriesCount++;
    }
}
