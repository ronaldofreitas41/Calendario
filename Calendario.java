/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg1trim;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author ronal
 */
public class Tp1trim {

    public static boolean anobissexto(int ano) {
        boolean sim;
        if (ano % 4 == 0) {
            sim = true;
        } else {
            sim = false;
        }
        return sim;
        /*este metodo so e utilizado na opçao 1 pra saber se o ano imformado e bissexto ou nao
         */
    }

    public static void imprimecalendario(int pd, boolean bissexto) {
        /*
        este metodo possui exclusivamente a funcao de imprimir o calendario anual     
         */
        int meses[][] = new int[6][7], ud = 0;
        for (int mes = 1; mes <= 12; mes++) {
            /*
            este for e utilizado para saber em qual esta a se executar
             */
            switch (mes) {
                case 1: {
                    System.out.println("       Janeiro       ");
                    ud = 31;
                    break;
                }
                case 2: {
                    System.out.println("       Feveiro       ");
                    if (bissexto == true) {
                        ud = 29;
                    }
                    if (bissexto == false) {
                        ud = 28;
                    }
                    break;
                }
                case 3: {
                    System.out.println("        Março         ");
                    ud = 31;
                    break;
                }
                case 4: {
                    System.out.println("         Abril        ");
                    ud = 30;
                    break;
                }
                case 5: {
                    System.out.println("         Maio        ");
                    ud = 31;
                    break;
                }
                case 6: {
                    System.out.println("        Junho        ");
                    ud = 30;
                    break;
                }
                case 7: {
                    System.out.println("        Julho        ");
                    ud = 31;
                    break;
                }
                case 8: {
                    System.out.println("        Agosto       ");
                    ud = 31;
                    break;
                }
                case 9: {
                    System.out.println("       Setembro      ");
                    ud = 30;
                    break;
                }
                case 10: {
                    System.out.println("       Outubro       ");
                    ud = 31;
                    break;
                }
                case 11: {
                    System.out.println("       Novembro      ");
                    ud = 30;
                    break;
                }
                case 12: {
                    System.out.println("       Dezembro      ");
                    ud = 31;
                    break;
                }
            }
            /*
            o switch acima tem a funçao de saber qual mes esta se executando para
            escrever seu nome e saber qual sera seu ultimo dia como o ano pode ser
            bissexto ou não no case 2 possui um if para fazer tal verificaçao
             */
            if (pd == 7) {
                pd = 0;
            }
            /*
            este if serve para saber se o primeiro dia do mes estadentre as limitaçoes
           da matriz
             */
            int diames = 1;
            boolean acabou = false;
            System.out.print("\u001B[43m" + "\u001B[31m" + "D  ");
            System.out.println("\u001B[43m" + "\u001B[30m" + "S  T  Q  Q  S  S  ");
            /*
            estes souts possuem dois tipos de codigos de coloraços para o background
            e para as letras dos dias da semana sendo cinza o background e vermelho e 
            branco as letras
             */
            for (int semanas = 0; semanas < 6; semanas++) {
                /*
                este for e pra saber em qual semana do mes estamos
                 */
                int dias = 0;
                if (acabou == true) {
                    break;
                }
                // este if serve pra saber se o mes acabou ou nao
                if (semanas == 0) {
                    for (int espacos = 1; espacos <= pd; espacos++) {
                        System.out.print("\u001B[47m" + "   ");
                    }
                    for (dias = pd; dias < 7; dias++) {
                        meses[semanas][dias] = diames;
                        if (dias == 0) {
                            System.out.print("\u001B[47m" + "\u001B[31m" + meses[semanas][dias] + "  ");
                        } else {
                            System.out.print("\u001B[47m" + "\u001B[30m" + meses[semanas][dias] + "  ");
                        }
                        diames++;
                    }
                    System.out.println("");
                    /*
                    este for tem como funçao imprimir os espaços andes do primeiro
                    dia da primeira semana de cada mes e imprimir seus dias tambem 
                    visto que eles tem que começar da posiçao do valor da variavel
                    pd por isso estao separados
                     */
                } else {
                    for (dias = 0; dias < 7; dias++) {
                        meses[semanas][dias] = diames;
                        if (diames < 10) {
                            if (dias == 0) {
                                System.out.print("\u001B[47m" + "\u001B[31m" + meses[semanas][dias] + "  ");
                            } else {
                                System.out.print("\u001B[47m" + "\u001B[30m" + meses[semanas][dias] + "  ");
                            }
                        } else {
                            if (dias == 0) {
                                System.out.print("\u001B[47m" + "\u001B[31m" + meses[semanas][dias] + " ");
                            } else {
                                System.out.print("\u001B[47m" + "\u001B[30m" + meses[semanas][dias] + " ");
                            }
                        }
                        if (diames == ud) {
                            pd = dias + 1;
                            acabou = true;
                            break;
                        }

                        diames++;
                    }
                    System.out.println("");
                }
                /*
                ja este restante seria a continuaçao da primeira semana  e tambem
                se verifica se o mes ja acabou ou nao e ao final de cada semana 
                ele quebra um linha
                 */
            }
            System.out.println("");
            //esse sout serve para ter mais espaço entre os meses
        }
    }

    public static int calculaprimeirodia(int ano) {

        Vector<Integer> vet = new Vector<>();
        for (int anos = 1972; anos <= ano; anos += 4) {
            vet.add(anos);
        }
        int size = vet.size(), pd;
        if (ano % 4 == 0) {
            size -= 1;
            /*
            este if foi criado pois se o ano for bissexto o size recebera seu valor mas 
            ele nao afeta seu primeiro dia mais sim o primeiro dia dos anos seguintes a ele
            ligo tera de haver esse -1
             */
        }
        pd = ((((ano - 1970) + 4) % 7) + size) % 7;
        return pd;
        /*
        para calcular quanto que os anos ateriores interferem no primeiro dia do
        ano eu criei essa formula apartir do tamanho de um vetor dinamico em que
        a cada ano biisexto passado se adiciona uma casa dai entao você pega 
        o ano informado pelo usuário menos o menor ano aceitavel que e 1970 
        mais 4 que é a posição em que o primeiro dia do ano de 1970 esta ai pega-se
        o resto de sua divisao por 7 mais a quantidade de posições do vetor dinamico
        e por fim pega o resto dessa soma na divisao por sete e se acha o primeiro
        dia da semanda de cada ano
         */
    }

    public static void main(String[] args) {
        int op, pd;
        Scanner teclado = new Scanner(System.in);
        System.out.println("se voce quiser me informar o ano do caledario digite 1"
                + "\nse quiser dizer o dia da semana que o ano começou digite 2");
        op = teclado.nextInt();
        /* 
        aqui recolhe-se se o usuario quer entrar com o primeiro dia da semana do ano
        ou com o ano do calendario 
         */
        switch (op) {
            case 1: {
                System.out.println("informe seu ano obs: acima de 1970");
                int ano = teclado.nextInt();
                if (ano >= 1970) {
                    pd = calculaprimeirodia(ano);
                    boolean anos = anobissexto(ano);
                    imprimecalendario(pd, anos);
                    break;
                } else {
                    System.err.println("voce informou um ano invalido");
                    break;
                }
                /* como nesta opçao eu informo o ano eu preciso saber se ele e bissexto
             e tambem calcular seu primeiro dia
                 */
            }
            case 2: {
                System.out.println("informe o dia em que começa seu ano: 0-domingo;"
                        + "\n1-segunda;"
                        + "\n2-terça;"
                        + "\n3-quarta;"
                        + "\n4-quinta;"
                        + "\n5-sexta;"
                        + "\n6-sabado");
                pd = teclado.nextInt();
                imprimecalendario(pd, false);
                /* nesta opçao como ela eu so tenho o primeiro dia nao tem como
                saber se o ano e bissexto ou nao eu ja passo como parametro ele 
                nao sendo bissexto e tambem nao ha necessidade do calculo do primeiro dia 
                 */
                break;
            }
        }
    }
}
