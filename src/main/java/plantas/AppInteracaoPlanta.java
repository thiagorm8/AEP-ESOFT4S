package plantas;

import plantas.especiePlanta.BuscarPlanta;
import plantas.especiePlanta.EspeciePlanta;
import plantas.plantasUsuario.PlantasUsuario;
import plantas.usuario.Usuario;

import java.util.*;

public class AppInteracaoPlanta {

    public static void main(String[] args) {

        EspeciePlanta tomate = new EspeciePlanta(
                "Tomate",
                "Fruta",
                "Anual",
                "Irrigar Regularmente",
                "Inverno",
                "Arenoso"
        );

        Map<String, EspeciePlanta> plantas = new HashMap<>();
        plantas.put(tomate.getNomeEspecie(), tomate);

        Scanner leia = new Scanner(System.in);
        Usuario usuario = new Usuario();

        System.out.println("Seja bem vindo, vamos iniciar seu cadastro: ");
        usuario.cadastrarUsuario();

        boolean logadoComSucesso = false;
        while (!logadoComSucesso) {
            System.out.println("Agora para acessar o app, efetue seu login!");
            logadoComSucesso = usuario.login();
        }
        
        int opcao = 0;
        do
        {
            System.out.println("\nEscolha uma opção abaixo: \n");
            System.out.println("\n1 - Adidionar nova planta em sua horta\n");
            System.out.println("\n2 - Mostrar sua plantação\n");
            System.out.println("\n3 - Mostrar informações sobre determinada planta\n");
            opcao = leia.nextInt();

            switch (opcao)
            {
                case 1: {
                    PlantasUsuario novaPlantasUsuario = new PlantasUsuario();
                    novaPlantasUsuario.criarPlantaUsuario(plantas);
                    usuario.addPlantacao(novaPlantasUsuario);
                    break;
                }
                case 2:
                    System.out.println(usuario.mostrarPlantacao()); break;
                case 3: {
                    EspeciePlanta especiePlantaEncontrada = BuscarPlanta.buscarEspeciePlanta(plantas);
                    System.out.println(especiePlantaEncontrada);
                    break;
                }

            }

        }while (opcao != 0);


    }

}
