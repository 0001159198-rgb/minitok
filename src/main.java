import java.util.List;
import java.util.Scanner;

public class Main {
git
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        usuarioDAO usuarioDAO = new usuarioDAO();   // Supondo que você já implementou o DAO
        postagemDAO postagemDAO = new postagemDAO();
        curtidaDAO curtidaDAO = new curtidaDAO();
        directDAO directDAO = new directDAO();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Criar usuário");
            System.out.println("2. Listar usuários");
            System.out.println("3. Atualizar usuário");
            System.out.println("4. Excluir usuário");
            System.out.println("5. Criar postagem");
            System.out.println("6. Listar postagens de um usuário");
            System.out.println("7. Excluir postagem");
            System.out.println("8. Curtir postagem");
            System.out.println("9. Descurtir postagem");
            System.out.println("10. Mostrar quantidade de curtidas");
            System.out.println("11. Enviar Direct");
            System.out.println("12. Listar Directs entre dois usuários");
            System.out.println("13. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // Consumir a quebra de linha

            switch (opcao) {

                case 1: // Criar usuário
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    if (email.isEmpty()) {
                        System.out.println("Email não pode ser vazio!");
                        break;
                    }

                    System.out.print("Senha: ");
                    String senha = sc.nextLine();

                    usuario usuario = new usuario();
                    usuario.setNome(nome);
                    usuario.setEmail(email);
                    usuario.setSenha(senha);
                    usuario.setDataCadastro(java.time.LocalDate.now());

                    usuarioDAO.salvar(usuario);
                    System.out.println("Usuário criado com sucesso!");
                    break;

                case 2: // Listar usuários
                    List<usuario> usuarios = usuarioDAO.listarTodos();
                    System.out.println("=== LISTA DE USUÁRIOS ===");
                    for (usuario u : usuarios) {
                        System.out.println("ID: " + u.getId() + " | Nome: " + u.getNome() + " | Email: " + u.getEmail());
                    }
                    break;

                case 3: // Atualizar usuário
                    System.out.print("Digite o ID do usuário: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();
                    usuario uAtualizar = usuarioDAO.buscarPorId(idAtualizar);
                    if (uAtualizar == null) {
                        System.out.println("Usuário não encontrado!");
                        break;
                    }

                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Novo email: ");
                    String novoEmail = sc.nextLine();
                    System.out.print("Nova senha: ");
                    String novaSenha = sc.nextLine();

                    uAtualizar.setNome(novoNome);
                    uAtualizar.setEmail(novoEmail);
                    uAtualizar.setSenha(novaSenha);

                    usuarioDAO.atualizar(uAtualizar);
                    System.out.println("Usuário atualizado com sucesso!");
                    break;

                case 4: // Excluir usuário
                    System.out.print("Digite o ID do usuário a excluir: ");
                    int idExcluir = sc.nextInt();
                    sc.nextLine();
                    usuarioDAO.deletar(idExcluir);
                    System.out.println("Usuário excluído com sucesso!");
                    break;

                case 5: // Criar postagem
                    System.out.print("ID do usuário: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Conteúdo da postagem: ");
                    String conteudo = sc.nextLine();

                    if (conteudo.isEmpty()) {
                        System.out.println("Conteúdo não pode ser vazio!");
                        break;
                    }

                    postagem postagem = new postagem();
                    postagem.setUsuarioId(userId);
                    postagem.setConteudo(conteudo);
                    postagem.setDataPostagem(java.time.LocalDate.now());

                    postagemDAO.salvar(postagem);
                    System.out.println("Postagem criada com sucesso!");
                    break;

                case 6: // Listar postagens de um usuário
                    System.out.print("ID do usuário: ");
                    int userIdPost = sc.nextInt();
                    sc.nextLine();
                    List<postagem> postagens = postagemDAO.listarPorUsuario(userIdPost);
                    System.out.println("=== POSTAGENS ===");
                    for (postagem p : postagens) {
                        System.out.println("ID: " + p.getId() + " | Conteúdo: " + p.getConteudo() + " | Data: " + p.getDataPostagem());
                    }
                    break;

                case 7: // Excluir postagem
                    System.out.print("ID da postagem: ");
                    int postId = sc.nextInt();
                    sc.nextLine();
                    postagemDAO.deletar(postId);
                    System.out.println("Postagem excluída com sucesso!");
                    break;

                case 8: // Curtir postagem
                    System.out.print("ID do usuário: ");
                    int idCurtidor = sc.nextInt();
                    System.out.print("ID da postagem: ");
                    int idPostCurtir = sc.nextInt();
                    sc.nextLine();

                    if (!curtidaDAO.verificarSeJaCurtiu(idCurtidor, idPostCurtir)) {
                        curtidaDAO.curtir(idCurtidor, idPostCurtir);
                        System.out.println("Postagem curtida com sucesso!");
                    } else {
                        System.out.println("Você já curtiu esta postagem!");
                    }
                    break;

                case 9: // Descurtir postagem
                    System.out.print("ID do usuário: ");
                    int idDescurtir = sc.nextInt();
                    System.out.print("ID da postagem: ");
                    int idPostDescurtir = sc.nextInt();
                    sc.nextLine();

                    curtidaDAO.descurtir(idDescurtir, idPostDescurtir);
                    System.out.println("Curtida removida com sucesso!");
                    break;

                case 10: // Mostrar quantidade de curtidas
                    System.out.print("ID da postagem: ");
                    int idPostQtd = sc.nextInt();
                    sc.nextLine();
                    int qtd = curtidaDAO.contarCurtidas(idPostQtd);
                    System.out.println("Total de curtidas: " + qtd);
                    break;

                case 11: // Enviar Direct
                    System.out.print("ID do remetente: ");
                    int remetente = sc.nextInt();
                    System.out.print("ID do destinatário: ");
                    int destinatario = sc.nextInt();
                    sc.nextLine();

                    if (remetente == destinatario) {
                        System.out.println("Não é possível enviar mensagem para si mesmo!");
                        break;
                    }

                    System.out.print("Mensagem: ");
                    String msg = sc.nextLine();

                    direct direct = new direct();
                    direct.setRemetenteId(remetente);
                    direct.setDestinatarioId(destinatario);
                    direct.setMensagem(msg);
                    direct.setDataEnvio(java.time.LocalDate.now());

                    directDAO.enviarMensagem(direct);
                    System.out.println("Mensagem enviada com sucesso!");
                    break;

                case 12: // Listar Directs entre dois usuários
                    System.out.print("ID do usuário 1: ");
                    int user1 = sc.nextInt();
                    System.out.print("ID do usuário 2: ");
                    int user2 = sc.nextInt();
                    sc.nextLine();

                    List<direct> directs = directDAO.listarMensagens(user1, user2);
                    System.out.println("=== MENSAGENS ENTRE USUÁRIOS ===");
                    for (direct d : directs) {
                        System.out.println("De: " + d.getRemetenteId() + " | Para: " + d.getDestinatarioId() +
                                " | Mensagem: " + d.getMensagem() + " | Data: " + d.getDataEnvio());
                    }
                    break;

                case 13: // Sair
                    continuar = false;
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        sc.close();
    }
}
