package DOTS;

import DOTS.server.gameStart;

public class Path<T> {
    public Node<T> Startpoint;
    public Node<T> current;
    private Node<T> head;
    public VectorList<T> visited = new VectorList<T>();
    public Stack<T> stack = new Stack<T>();
    public Figures figures = new Figures();
    public int vertices;
    public SimpleLinkedListLines<T> coords = new SimpleLinkedListLines<T>();

    public Path(Node Startpoint) {
        this.Startpoint = Startpoint;
    }

    /**
     * en este metodo busca un elemento de una lista
     * @param nodelines
     * @param node2compare
     * @return booleano depende de si se encuentra o no
     */
    public boolean search(Node nodelines, Node node2compare) {
        for (int i = 0; i < nodelines.lineas.getSize(); i++) {
            if (node2compare == nodelines.lineas.getNode(i).getData()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca un elemento dentro de uan lista
     * @param nodei
     * @param nodef
     * @param dir
     * @param list
     * @return boleano
     */
    public boolean in(Node nodei, Node nodef, int dir, VectorList list) {
        VectorNode node = new VectorNode(nodei, nodef, dir);
        for (int i = 0; i < list.size(); i++) {
            if (node == list.getVectorNode(i)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Verifica que la figura se haya cerrado o no
     * @param Startpoint
     * @return
     */
    public boolean Vertices(Node Startpoint) {
        try {
            current = Startpoint;
            Node<T> previous = null;
            int contador = 0;
            int vertices = 0;
            boolean flag = false;
            while (current != Startpoint || contador == 0) {
                if ((current.lineas.getSize() == 1 && current.lineas.getNode(0).getData() == previous) || current.lineas.getSize() == current.checked) {
                    current = previous;
                    previous = stack.pop();
                    flag=true;
                } else {
                    current.checked++;
                    if (search(current, current.getRight()) && !in(current, current.getRight(), 0, visited)&& current.getRight()!=previous) {
                        flag=false;
                        visited.append(current, current.getRight(), 0);
                        if (contador == 0) {
                            contador++;
                        } else {
                            if (visited.getVectorNode(contador - 1).getDir() == visited.getVectorNode(contador).getDir()) {
                                contador++;
                            } else {
                                vertices++; coords.append((T) figures.NodeToCoords(current));
                                contador++;
                            }
                        }

                        stack.push(previous);
                        previous = current;
                        current = current.getRight();
                    } else if (search(current, current.getDru()) && !in(current, current.getDru(), 1, visited)&& current.getDru()!=previous) {
                        flag=false;
                        visited.append(current, current.getDru(), 1);
                        if (contador == 0) {
                            contador++;
                        } else {
                            if (visited.getVectorNode(contador - 1).getDir() == visited.getVectorNode(contador).getDir()) {

                                contador++;
                            } else {
                                vertices++; coords.append((T) figures.NodeToCoords(current));
                                contador++;
                            }
                        }
                        stack.push(previous);
                        previous = current;
                        current = current.getDru();
                    } else if (search(current, current.getUp()) && !in(current, current.getUp(), 2, visited)&& current.getUp()!=previous) {
                        flag=false;
                        visited.append(current, current.getUp(), 2);
                        if (contador == 0) {
                            contador++;
                        } else {
                            if (visited.getVectorNode(contador - 1).getDir() == visited.getVectorNode(contador).getDir()) {

                                contador++;
                            } else {
                                vertices++; coords.append((T) figures.NodeToCoords(current));
                                contador++;
                            }
                        }
                        stack.push(previous);
                        previous = current;
                        current = current.getUp();
                    } else if (search(current, current.getDlu()) && !in(current, current.getDlu(), 3, visited)&& current.getDlu()!=previous) {
                        flag=false;
                        visited.append(current, current.getDlu(), 3);
                        if (contador == 0) {
                            contador++;
                        } else {
                            if (visited.getVectorNode(contador - 1).getDir() == visited.getVectorNode(contador).getDir()) {

                                contador++;
                            } else {
                                vertices++; coords.append((T) figures.NodeToCoords(current));
                                contador++;
                            }
                        }
                        stack.push(previous);
                        previous = current;
                        current = current.getDlu();
                    } else if (search(current, current.getLeft()) && !in(current, current.getLeft(), 4, visited) && current.getLeft()!=previous) {
                        flag=false;
                        visited.append(current, current.getLeft(), 4);
                        if (contador == 0) {
                            contador++;
                        } else {
                            if (visited.getVectorNode(contador - 1).getDir() == visited.getVectorNode(contador).getDir()) {

                                contador++;
                            } else {
                                vertices++; coords.append((T) figures.NodeToCoords(current));
                                contador++;
                            }
                        }
                        stack.push(previous);
                        previous = current;
                        current = current.getLeft();
                    } else if (search(current, current.getDld()) && !in(current, current.getDld(), 5, visited)&& current.getDld()!=previous) {
                        flag=false;
                        visited.append(current, current.getDld(), 5);
                        if (contador == 0) {
                            contador++;
                        } else {
                            if (visited.getVectorNode(contador - 1).getDir() == visited.getVectorNode(contador).getDir()) {

                                contador++;
                            } else {
                                vertices++; coords.append((T) figures.NodeToCoords(current));
                                contador++;
                            }
                        }
                        stack.push(previous);
                        previous = current;
                        current = current.getDld();
                    } else if (search(current, current.getDown()) && !in(current, current.getDown(), 6, visited)&& current.getDown()!=previous) {
                        flag=false;
                        visited.append(current, current.getDown(), 6);
                        if (contador == 0) {
                            contador++;
                        } else {
                            if (visited.getVectorNode(contador - 1).getDir() == visited.getVectorNode(contador).getDir()) {

                                contador++;
                            } else {
                                vertices++; coords.append((T) figures.NodeToCoords(current));
                                contador++;
                            }
                        }
                        stack.push(previous);
                        previous = current;
                        current = current.getDown();
                    } else if (search(current, current.getDrd()) && !in(current, current.getDrd(), 7, visited)&& current.getDrd()!=previous) {
                        flag=false;
                        visited.append(current, current.getDrd(), 7);
                        if (contador == 0) {
                            contador++;
                        } else {
                            if (visited.getVectorNode(contador - 1).getDir() == visited.getVectorNode(contador).getDir()) {

                                contador++;
                            } else {
                                vertices++; coords.append((T) figures.NodeToCoords(current));
                                contador++;
                            }
                        }
                        stack.push(previous);
                        previous = current;
                        current = current.getDrd();
                    }
                }
            }
            if (!flag) {
                current.checked++;
                if (search(current, current.getRight()) && !in(current, current.getRight(), 0, visited)&& current.getRight()!=previous) {
                    visited.append(current, current.getRight(), 0);
                    if (visited.getVectorNode(contador - 1).getDir() == visited.getVectorNode(contador).getDir()) {
                        contador++;
                    } else {
                        vertices++; coords.append((T) figures.NodeToCoords(current));
                        contador++;
                    }
                    stack.push(previous);
                    previous = current;
                    current = current.getRight();
                } else if (search(current, current.getDru()) && !in(current, current.getDru(), 1, visited)&& current.getDru()!=previous) {
                    visited.append(current, current.getDru(), 1);
                    if (contador == 0) {
                        contador++;
                    } else {
                        if (visited.getVectorNode(contador - 1).getDir() == visited.getVectorNode(contador).getDir()) {
                            contador++;
                        } else {
                            vertices++; coords.append((T) figures.NodeToCoords(current));
                            contador++;
                        }
                    }
                    stack.push(previous);
                    previous = current;
                    current = current.getDru();
                } else if (search(current, current.getUp()) && !in(current, current.getUp(), 2, visited)&& current.getUp()!=previous) {
                    visited.append(current, current.getUp(), 2);
                    if (contador == 0) {
                        contador++;
                    } else {
                        if (visited.getVectorNode(contador - 1).getDir() == visited.getVectorNode(contador).getDir()) {
                            contador++;
                        } else {
                            vertices++; coords.append((T) figures.NodeToCoords(current));
                            contador++;
                        }
                    }
                    stack.push(previous);
                    previous = current;
                    current = current.getUp();
                } else if (search(current, current.getDlu()) && !in(current, current.getDlu(), 3, visited)&& current.getDlu()!=previous) {
                    visited.append(current, current.getDlu(), 3);
                    if (contador == 0) {
                        contador++;
                    } else {
                        if (visited.getVectorNode(contador - 1).getDir() == visited.getVectorNode(contador).getDir()) {
                            contador++;
                        } else {
                            vertices++; coords.append((T) figures.NodeToCoords(current));
                            contador++;
                        }
                    }
                    stack.push(previous);
                    previous = current;
                    current = current.getDlu();
                } else if (search(current, current.getLeft()) && !in(current, current.getLeft(), 4, visited)&& current.getLeft()!=previous) {
                    visited.append(current, current.getLeft(), 4);
                    if (contador == 0) {
                        contador++;
                    } else {
                        if (visited.getVectorNode(contador - 1).getDir() == visited.getVectorNode(contador).getDir()) {
                            contador++;
                        } else {
                            vertices++; coords.append((T) figures.NodeToCoords(current));
                            contador++;
                        }
                    }
                    stack.push(previous);
                    previous = current;
                    current = current.getLeft();
                } else if (search(current, current.getDld()) && !in(current, current.getDld(), 5, visited)&& current.getDld()!=previous) {
                    visited.append(current, current.getDld(), 5);
                    if (contador == 0) {
                        contador++;
                    } else {
                        if (visited.getVectorNode(contador - 1).getDir() == visited.getVectorNode(contador).getDir()) {
                            contador++;
                        } else {
                            vertices++; coords.append((T) figures.NodeToCoords(current));
                            contador++;
                        }
                    }
                    stack.push(previous);
                    previous = current;
                    current = current.getDld();
                } else if (search(current, current.getDown()) && !in(current, current.getDown(), 6, visited)&& current.getDown()!=previous) {
                    visited.append(current, current.getDown(), 6);
                    if (contador == 0) {
                        contador++;
                    } else {
                        if (visited.getVectorNode(contador - 1).getDir() == visited.getVectorNode(contador).getDir()) {
                            contador++;
                        } else {
                            vertices++; coords.append((T) figures.NodeToCoords(current));
                            contador++;
                        }
                    }
                    stack.push(previous);
                    previous = current;
                    current = current.getDown();
                } else if (search(current, current.getDrd()) && !in(current, current.getDrd(), 7, visited)&& current.getDrd()!=previous) {
                    visited.append(current, current.getDrd(), 7);
                    if (contador == 0) {
                        contador++;
                    } else {
                        if (visited.getVectorNode(contador - 1).getDir() == visited.getVectorNode(contador).getDir()) {
                            contador++;
                        } else {
                            vertices++; coords.append((T) figures.NodeToCoords(current));
                            contador++;
                        }
                    }
                    stack.push(previous);
                    previous = current;
                    current = current.getDrd();
                }
                gameStart.getP1().setShapes(coords);
                gameStart.getP2().setShapes(coords);
                figures.identify(vertices, coords.getSize());
                return true;
            }
            else if (flag && current.checked==current.lineas.getSize()){
                return false;
            }
            else{
                Vertices(current);
            }
        } catch (NullPointerException e) {
            System.out.println("Hacer algo si no sirve");
        }
        return false;
    }

}

