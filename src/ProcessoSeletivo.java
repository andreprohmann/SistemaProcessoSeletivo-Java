package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE" };
        for(String candidato : candidatos) {
           entrandoEmContato(candidato);
        }
    }
    static void entrandoEmContato( String candidato){
        int tentivasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu=false;
        do {
            atendeu= atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentivasRealizadas++;
            }else
                System.out.println("CONTATO REALIZADO COM SUCESSO");
        }while(continuarTentando && tentivasRealizadas < 3);
            if(atendeu)
                System.out.println("CONSEGUIMOS CONTATO COM " + candidato + "NA " + tentivasRealizadas);
            else
                System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MÁXIMO DE TENTATIVAS " + tentivasRealizadas);
    }

    private static boolean atender() {
        return new Random().nextInt(3) ==1;
    }

    static void imprimirSelecionados(){
        String [] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE" };
        System.out.println("Imprimindo Lista de candidatos informando o indice do elemento");
        for(int i = 0; i < candidatos.length; i++){
            System.out.println("O candidato de nº " + (i+1) + " é: " + candidatos[i]);
        }
    }

    static void selecaoCandidatos(){
        //Array com a lista de candidatos
        String [] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE" };
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("Candidato: " + candidato + "Solicitado o valor:" + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O Candidato "+ candidato + "foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        }else if(salarioBase == salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRAPROPOSTA");
        }else {
            System.out.println("AGUARDANDO DEMAIS CANDIDATO");
        }
    }
}
