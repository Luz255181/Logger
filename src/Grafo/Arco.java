package Grafo;

public class Arco
{
	protected int sucesor, predecesor;
	
	/**
	 * Crea un arco que conecta dos nodos.
	 * @param pre Primer nodo.
	 * @param su Segudno nodo.
	 */
	public Arco(int pre, int su)
	{
		predecesor = pre;
		sucesor = su;
	}

	/**
	 * Devuelve el primer nodo.
	 * @return Primer nodo.
	 */
	public int getPredecesor()
	{
		return predecesor;
	}
	
	/**
	 * Devuelve el segundo nodo.
	 * @return Segundo nodo.
	 */
	public int getSucesor()
	{
		return sucesor;
	}
	
	/**
	 * Setea el valor del primer nodo.
	 * @param p Primer nodo.
	 */
	public void setPredecesor(int p)
	{
		predecesor = p;
	}
	
	/**
	 * Setea el valor del segundo nodo.
	 * @param s Segudno nodo.
	 */
	public void setSucesor(int s)
	{
		sucesor = s;
	}
}
