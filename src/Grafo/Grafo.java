package Grafo;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Iterator;
import Exception.*;
import Lista.*;

public class Grafo
{
	protected ListaDobleEnlace<Integer> ListaVertices ;
	protected ListaDobleEnlace<Arco> ListaArcos;
	private static Logger logger;

	/**
	 * Crea un grafo vacio.
	 */
	public Grafo()
	{
		ListaVertices = new ListaDobleEnlace<Integer>();
		ListaArcos = new ListaDobleEnlace<Arco>();
		if (logger == null){

			logger = Logger.getLogger(Grafo.class.getName());

			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.WARNING);
			logger.addHandler(hnd);

			logger.setLevel(Level.FINE);

			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()){
				h.setLevel(Level.OFF);
			}
		}
	}

	/**
	 * Agrega un nodo al grafo con el rotulo ingresado.
	 * @param node Rotulo del nodo a agregar.
	 */
	public void addNode(int node)
	{
		int aux;
		boolean encontre = false;
		Iterator<Integer> lista = ListaVertices.iterator();
		while(!encontre && lista.hasNext() )
		{
			aux = lista.next();
			if(aux == node)
				encontre = true;
		}
		if(encontre)
			logger.warning("El nodo " + node + " ya pertenece al grafo");
		else
		{
			ListaVertices.addLast(node);
			logger.info("Se agrego el nodo " + node + " al grafo");
		}
	}

	/**
	 * Crea un arco que conecta 2 nodos dados, con sentido del nodo 1 al nodo 2.
	 * @param node1 Nodo donde inicia el vertice.
	 * @param node2 Nodo donde finaliza el vertice.
	 */
	public void addEdge(int node1, int node2)
	{
		int aux;
		boolean encontre1 = false;
		boolean encontre2 = false;
		Iterator<Integer> lista = ListaVertices.iterator();
		while((!encontre1 | !encontre2) && lista.hasNext() )
		{
			aux = lista.next();
			if(aux == node1)
				encontre1 = true;
			else
			{
				if(aux == node2)
					encontre2 = true;
			}
		}
		if(encontre1 & encontre2)
		{
			Iterator<Arco> listaA = ListaArcos.iterator();
			boolean existe = false;
			Arco ver = null;
			while(!existe && listaA.hasNext())
			{
				ver = listaA.next();
				if(node1 == ver.getPredecesor())
				{
					if(node2 == ver.getSucesor());
					{
						existe = true;
					}
				}
			}
			if(existe)
				logger.warning("El arco que une " + node1 + " y " + node2 + "ya existe");
			else
			{
				Arco nuevo = new Arco(node1, node2);
				ListaArcos.addLast(nuevo);
				logger.info("Se agrego el arco que conecta " + node1 + " y " + node2);
			}
		}
		else
		{
			Arco nuevo = new Arco(node1, node2);
			ListaArcos.addLast(nuevo);
			logger.info("Se agrego el arco que conecta " + node1 + " y " + node2);
		}
	}

	/**
	 * Elimina el nodo con el rotulo ingresado.
	 * @param node Rotulo del nodo a eliminar.
	 */
	public void removeNode(int node)
	{
		try
		{
			Position<Integer> aux = null;
			boolean encontre = false;
			Iterator<Position<Integer>> lista = ListaVertices.positions().iterator();
			while(!encontre && lista.hasNext() )
			{
				aux = lista.next();
				if(aux.element() == node)
				{
					encontre = true;
					ListaVertices.remove(aux);
				}
			}
			if(encontre)
			{
				Iterator<Position<Arco>> listaA = ListaArcos.positions().iterator();
				Position<Arco> ver = null;
				while(listaA.hasNext())
				{
					ver = listaA.next();
					if(node == ver.element().getPredecesor())
					{
						ListaArcos.remove(ver);
					}
					else 
					{
						if(node == ver.element().getSucesor())
						{
							ListaArcos.remove(ver);
						}
					}
				}
				logger.info("Se elimino el nodo " + node + " exitosamente");
			}
			else
				logger.warning("El nodo "+ node +" no existe");
		}
		catch(InvalidPositionException e)
		{
			logger.warning("Error");
		}
	}

	/**
	 * Elimina el vertice que conecta el nodo 1 y nodo 2.
	 * @param node1 Nodo donde inicia el vertice.
	 * @param node2 Nodo donde Finaliza el vertice.
	 */
	public void removeEdge(int node1, int node2)
	{
		try
		{
			boolean encontre = false;
			Iterator<Position<Arco>> lista = ListaArcos.positions().iterator();
			Position<Arco> arc = null;
			while(!encontre && lista.hasNext())
			{
				arc = lista.next();
				if(node1 == arc.element().getPredecesor() && node2 == arc.element().getSucesor())
				{
					ListaArcos.remove(arc);
					encontre = true;
					logger.info("El arco que conecta " + node1 + " y " + node2 + "fue removido con exito");
				}
			}
			if(!encontre)
				logger.warning("El arco que conecta " + node1 + " y " + node2 + "no existe");
		}
		catch(InvalidPositionException e)
		{
			logger.warning("Error");
		}
	}
}
