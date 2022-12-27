import entidade.Mes;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double consumoMedioMensal = 0;

        //populando
        int qtdMeses = 12*10; // 12*10
        Mes[] meses = new Mes[qtdMeses];
        for (int c=0;c<qtdMeses;c++) {
            Random aleatorio = new Random();
            meses[c] = new Mes();
            meses[c].gasto = aleatorio.nextInt(1000);
        }
        System.out.println("Populando tabela...");
        for (int c=0;c<qtdMeses;c++) {
            for (int a=2010;a<=2019;a++){
                for (int m=1;m<=12;m++){
                    meses[c].mes= String.valueOf(m);
                    if (m<10){meses[c].mes="0"+m;} //adicionando 0 antes dos meses até 9
                    meses[c].ano= String.valueOf(a);
                    c++;
                }
            }
        }

        //exibindo antes de ordenar
        String texto ="";
        //System.out.println("\nANTES DE ORDENAR:");
        for (int i=0;i<meses.length;i++){texto += "\n"+meses[i].mes+"/"+meses[i].ano+" R$" + meses[i].gasto;}
        //System.out.println(texto);

        //ordenando
        System.out.println("\nOrdenando dados...");
        for (int i=0;i<meses.length-1;i++){
            for (int j=i+1; j< meses.length; j++){
                if (meses[i].gasto<meses[j].gasto){
                    Mes temp=meses[i];
                    meses[i]=meses[j];
                    meses[j]=temp;
                }
            }
        }

        //calculando consumoMedioMensal
        double gastoTotal = 0;
        for (int i=0;i<qtdMeses;i++){gastoTotal+= meses[i].gasto;}
        consumoMedioMensal = gastoTotal/qtdMeses;

        //exibindo ordenado
        //System.out.println("\nAPÓS ORDENAR:");
        for (int i=0;i<meses.length;i++){texto += "\n"+meses[i].mes+"/"+meses[i].ano+" R$" + meses[i].gasto;}
        //System.out.println(texto);

        System.out.println(
                "\nCONSUMO MÉDIO MENSAL: R$" + (int)consumoMedioMensal);
        System.out.println(
                "MÊS QUE MAIS GASTOU: " +meses[0].mes + "/" +meses[0].ano + " (valor: R$" + meses[0].gasto+")");
    }
}