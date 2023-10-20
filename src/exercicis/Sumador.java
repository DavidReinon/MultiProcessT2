package exercicis;

publicclassSumador{

publicintsumar(intn1,intn2){

System.out.println("Sumando de "+n1+" hasta "+n2);

intresultado=0;

for(inti=n1;i<=n2;i++){

resultado=resultado+i;

}

returnresultado;

}

publicstaticvoidmain(String[]args){

Sumadors=newSumador();

intn1=Integer.parseInt(args[0]);

intn2=Integer.parseInt(args[1]);

intresultado=s.sumar(n1,n2);

System.out.println("Resultado de este sumador: "+resultado);

}

}
