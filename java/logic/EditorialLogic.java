package logic;

import java.util.LinkedList;

import data.DataEditorial;
import entities.Editorial;

public class EditorialLogic {

	private DataEditorial dataEditorial=new DataEditorial();
	
    public LinkedList<Editorial> getAll()
    {
        return this.dataEditorial.getAll();
    }
	
    public Editorial getById(Editorial editorialToSearch)
    {
        return this.dataEditorial.getById(editorialToSearch);
    }
    
    public Editorial getByDesc(Editorial editorialToSearch)
    {
        return this.dataEditorial.getByDesc(editorialToSearch);
    }
    
	public void add(Editorial editorial) {

		this.dataEditorial.add(editorial);
	}
	
	public void update(Editorial editorial) 
	{
		this.dataEditorial.update(editorial);
	}
	
	public void delete(Editorial editorial)
    {
        this.dataEditorial.remove(editorial);
    }

}

