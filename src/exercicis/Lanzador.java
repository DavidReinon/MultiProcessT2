package exercicis;

import java.io.File;

import java.util.ArrayList;

import java.util.List;

public class Lanzador {

public static void lanzarSumador(Integern1, Integern2){

try{

String clase="es.florida.multiproceso.Sumador";

StringjavaHome=System.getProperty("java.home");

StringjavaBin=javaHome+File.separator+"bin"+File.separator+"java";

Stringclasspath=System.getProperty("java.class.path");

StringclassName=clase;

List<String>command=newArrayList<>();

command.add(javaBin);

command.add("-cp");

command.add(classpath);

command.add(className);

command.add(n1.toString());

command.add(n2.toString());

System.out.println("Comando que se pasa a ProcessBuilder: "+command);

System.out.println("Comando a ejecutar en cmd.exe: "+command.toString().replace(",",""));

ProcessBuilderbuilder=newProcessBuilder(command);

Processprocess=builder.start();

// Process process = builder.inheritIO().start();

// Process process = builder.redirectOutput(new File("temp.txt")).start();

process.waitFor();

System.out.println(process.exitValue());

}catch(Exceptione){

e.printStackTrace();

}

}

publicstaticvoidmain(String[]args){

Lanzadorl=newLanzador();

lanzarSumador(1,50);

lanzarSumador(51,100);

System.out.println("Ok");

}

}