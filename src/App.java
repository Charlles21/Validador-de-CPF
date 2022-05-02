import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        String cpf;
        int baseMultiplicadora = 10;
        int recebeSomaCpf = 0;
        int PenultimoDigito;
        int UltimoDigito;
        int totalDigitosCpf = 11;
        int NumeroCpf;
        char recebeDigito; 
        boolean PenultimoDigitoValido = false;
        boolean UltimoDigitoValido = false;

        System.out.print("Digite seu CPF: ");        
        cpf = input.nextLine();


        //*********************************CALCULO DO PRIMEIRO DIGITO*****************************

        recebeSomaCpf = CalculaPenultinoDigito(cpf, baseMultiplicadora, recebeSomaCpf);          
        

        PenultimoDigito = totalDigitosCpf - (recebeSomaCpf % totalDigitosCpf);
        

        NumeroCpf = ComparaPenultimoDigito(cpf);

        PenultimoDigitoValido = ValidaUltimoDigito(PenultimoDigitoValido, PenultimoDigito, NumeroCpf);

     

        //***********************************CALCULO ULTIMO DIGITO DO CPF********************************
        UltimoDigitoValido = CalculaUltimoDigito(cpf, recebeSomaCpf, PenultimoDigitoValido, UltimoDigitoValido);

        // valida o ultimo digito do cpf       

        validaCPF(PenultimoDigitoValido, UltimoDigitoValido);      



        input.close();

    }

    private static boolean CalculaUltimoDigito(String cpf, int recebeSomaCpf, boolean PenultimoDigitoValido,
        boolean UltimoDigitoValido) {
        int baseMultiplicadora;
        int UltimoDigito;
        int NumeroCpf;
        char recebeDigito;
        if(PenultimoDigitoValido){

            //resetar valores importantes            
            recebeSomaCpf = 0;
            NumeroCpf = 0;
            baseMultiplicadora = 11;

            for (int posicaoDigito = 0; posicaoDigito < 10; posicaoDigito++) {
                //resetar valores importantes
               

                recebeDigito= cpf.charAt(posicaoDigito);                       
                NumeroCpf = Integer.parseInt(String.valueOf(recebeDigito));
    
              //System.out.println(NumeroCpf);
              
                recebeSomaCpf += NumeroCpf * baseMultiplicadora;
                
                baseMultiplicadora--;
                
              }  

        }else{
            System.out.println("Primeiro Digito CPF invalido");
        }

        UltimoDigito = 11 - (recebeSomaCpf % 11);        

        NumeroCpf = ComparaUltimoDigitoDigito(cpf);

        //VAlida o ultimo digito do cpf
        UltimoDigitoValido = ValidaUltimoDigito(UltimoDigitoValido, UltimoDigito, NumeroCpf);

        return UltimoDigitoValido;
    }

    private static boolean ValidaUltimoDigito(boolean UltimoDigitoValido, int UltimoDigito, int NumeroCpf) {
        if(UltimoDigito == NumeroCpf){

            UltimoDigitoValido = true;           
        }else if(UltimoDigito >= 10){

            UltimoDigito = 0;

            if(UltimoDigito == NumeroCpf){

                UltimoDigitoValido = true;  
            }else{

                UltimoDigitoValido = false;
            }
        }
        return UltimoDigitoValido;
    }

    private static int ComparaPenultimoDigito(String cpf) {
        int NumeroCpf;
        char recebeDigito;
        recebeDigito= cpf.charAt(9);                     
        NumeroCpf = Integer.parseInt(String.valueOf(recebeDigito));
        return NumeroCpf;
    }

    private static int CalculaPenultinoDigito(String cpf, int baseMultiplicadora, int recebeSomaCpf) {
        int NumeroCpf;
        char recebeDigito;
        for (int posicaoDigito = 0; posicaoDigito < 9; posicaoDigito++) {
              
            recebeDigito= cpf.charAt(posicaoDigito);
                     
            NumeroCpf = Integer.parseInt(String.valueOf(recebeDigito));

          
            recebeSomaCpf += NumeroCpf * baseMultiplicadora; 
            baseMultiplicadora--;

          }
        return recebeSomaCpf;
    }

    private static int ComparaUltimoDigitoDigito(String cpf) {
        int NumeroCpf;
        char recebeDigito;
        recebeDigito= cpf.charAt(10);                     
        NumeroCpf = Integer.parseInt(String.valueOf(recebeDigito));
        return NumeroCpf;
    }

    private static void validaCPF(boolean PenultimoDigitoValido, boolean UltimoDigitoValido) {
        if(UltimoDigitoValido && PenultimoDigitoValido){
                System.out.println("CPF VALIDADO COM SUCESSO!");
        }else{
            System.out.println("CPF INVALIDO!");
        }
    }
}
