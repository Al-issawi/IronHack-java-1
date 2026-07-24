import java.util.ArrayList;
import java.util.Collections;




        public class Main {

            public static void main(String[] args) {

                // 1. Creamos la lista inicial con 10 invitados
                ArrayList<String> invitados = new ArrayList<>();

                invitados.add("Michael");
                invitados.add("Ana");
                invitados.add("Carlos");
                invitados.add("Pedro");
                invitados.add("Laura");
                invitados.add("David");
                invitados.add("Sofia");
                invitados.add("Juan");
                invitados.add("Marta");
                invitados.add("Luis");

                System.out.println(" FIESTA EN TU CASA ");
                System.out.println("Lista inicial de invitados:");
                System.out.println(invitados);
                System.out.println();


                // 2. Michael se va de viaje
                invitados.remove("Michael");

                System.out.println(" Michael está de viaje y no puede venir.");
                System.out.println("Lista actualizada:");
                System.out.println(invitados);
                System.out.println();


                // 3. Pepi viene con su novio Silvester
                invitados.add("Pepi");
                invitados.add("Silvester");

                System.out.println("✅ Pepi se apunta con su novio Silvester.");
                System.out.println("Lista actualizada:");
                System.out.println(invitados);
                System.out.println();


                // 4. Eva se cuela en la tercera posición
                invitados.add(2, "Eva");

                System.out.println("😎 Eva dice que se cuela en la tercera posición.");
                System.out.println("Lista actualizada:");
                System.out.println(invitados);
                System.out.println();


                // 5. Se apuntan 10 personas de la fiesta de al lado
                ArrayList<String> nuevosInvitados = new ArrayList<>();

                nuevosInvitados.add("Alberto");
                nuevosInvitados.add("Beatriz");
                nuevosInvitados.add("Cristina");
                nuevosInvitados.add("Daniel");
                nuevosInvitados.add("Elena");
                nuevosInvitados.add("Fernando");
                nuevosInvitados.add("Gabriela");
                nuevosInvitados.add("Hugo");
                nuevosInvitados.add("Isabel");
                nuevosInvitados.add("Jorge");

                invitados.addAll(nuevosInvitados);

                System.out.println("🎵 10 personas de la fiesta de al lado se apuntan a nuestra fiesta.");
                System.out.println("Lista actualizada:");
                System.out.println(invitados);
                System.out.println();


                // 6. Ordenamos la lista alfabéticamente
                Collections.sort(invitados);

                System.out.println("🔤 Ordenamos la lista alfabéticamente.");
                System.out.println("Lista definitiva de invitados:");
                System.out.println(invitados);
                System.out.println();


                // 7. Averiguamos quién es el último de la lista
                String ultimoInvitado = invitados.get(invitados.size() - 1);

                System.out.println("👤 El último invitado de la lista es: " + ultimoInvitado);
                System.out.println();


                // 8. Comprobamos si Pedro está en la lista
                if (invitados.contains("Pedro")) {

                    int posicionPedro = invitados.indexOf("Pedro");

                    // Sumamos 1 porque las posiciones de ArrayList empiezan en 0
                    System.out.println("🔎 Pedro está en la lista.");
                    System.out.println("Pedro está en la posición: " + (posicionPedro + 1));

                } else {

                    System.out.println("🔎 Pedro no está en la lista.");
                }

                System.out.println();


                // 9. Llega la policía y todos salen corriendo
                // Creamos otro ArrayList con la lista desordenada
                ArrayList<String> listaDesordenada = new ArrayList<>(invitados);

                Collections.shuffle(listaDesordenada);

                System.out.println("🚔 ¡LLEGA LA POLICÍA!");
                System.out.println("🏃‍♂️ Todos salen corriendo y se desordenan.");
                System.out.println("Lista original:");
                System.out.println(invitados);
                System.out.println();

                System.out.println("Lista desordenada:");
                System.out.println(listaDesordenada);
            }
        }
