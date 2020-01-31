/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinay
 */
public class FileManager {
    static ArrayList<Task> tasks=new ArrayList<>();
 String str="Rajeev";
 
    static
    {try
    {
        
        File file=new File("D:\\Application\\FileOn.txt");
        BufferedReader read=new BufferedReader(new FileReader(file));
        String str;
        while((str=read.readLine())!=null)
        {
            String splittedString[]=str.split(",");
            
           Date taskDate=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(splittedString[2]);
            Task t=new Task(splittedString[0], splittedString[1], taskDate);
            tasks.add(t);      
        }
        
    }
    catch(Exception e)
    {
        System.out.print("Reading Data Unsuccessful  "+e);
    
    }
        
    }
    
   
    public static ArrayList<Task> getTasks() {
        return tasks;
    }
    
    public static void saveList()
    {
        File file=new File("D:\\Application\\FileOn.txt");
        try
        {
        PrintWriter pw=new PrintWriter(file);
        for(Task t:tasks)
        {
            pw.println(t);
        }
        pw.close();
        }
        catch(Exception e)
        {
            
        }
       
        
    }
    
    public static ArrayList<String> getTaskList()
    {
        ArrayList<String> taskNames=new ArrayList<>();
        for(Task t:tasks)
        {
            taskNames.add(t.getTaskName());
        }
        return taskNames;
    }
    
    public static String getDescription(int i)
    {
        String str=tasks.get(i).getTaskDate()+"\n"+tasks.get(i).getTaskDescription();
        return str;
    }
    public static void removeRecord(int i)
    {
        tasks.remove(i);
    }
   
    public static void addRecord(Task t)
    {
        int insertionIndex=0;
        for(Task elListed:tasks)
        {
            
            if(t.getTaskDate().compareTo(elListed.getTaskDate())<0)
            {
                tasks.add(insertionIndex, t);
                 break;
            }
            insertionIndex++;
        }
        if(insertionIndex==tasks.size())
        {
          tasks.add(t);  
        }

         
         
    }
    
}
