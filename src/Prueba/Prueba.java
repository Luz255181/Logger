package Prueba;
import Grafo.*;

public class Prueba 
{
	public static void main(String[] args)
	{
		Grafo graf = new Grafo();
		
		//Agrego nodos al garfo.
		graf.addNode(23);
		graf.addNode(123);
		graf.addNode(22);
		graf.addNode(22);
		
		//Agrego arcos.
		graf.addEdge(23, 22);
		graf.addEdge(23, 22);
		graf.addEdge(123, 23);
		graf.addEdge(22, 123);
		
		//Elimino arcos.
		graf.removeEdge(23, 22);
		graf.removeEdge(23, 22);
		graf.removeEdge(23, 25);
		
		//Elimino nodos.
		graf.removeNode(23);
		graf.removeNode(25);
		
		//Verifico si los nodos perdieron las cnecciones con el nodo eliminado anteriormente.
		graf.removeEdge(23, 123);
		graf.removeEdge(123, 23);
	}

}
