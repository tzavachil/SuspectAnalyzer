import java.util.ArrayList;

public class Suspect {
	private String name;
	private String codename;
	private String country;
	private String city;
	private ArrayList<String> phones = new ArrayList<>();
	private ArrayList<Suspect> partners = new ArrayList<>();
	
	public Suspect(String name, String codename, String country, String city)
	{
		this.name = name;
		this.codename = codename;
		this.country = country;
		this.city = city;
	}
	
	//Constructor for empty Suspect object 
	public Suspect()
	{
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCodeName() {
		return this.codename;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	//Adding a phone number to the suspect's phones list
	public void addNumber(String phone)
	{
		this.phones.add(phone);
	}
	
	//Adding a possible suspect to suspect's partners list
	public void addPossibleSuspect(Suspect aSuspect)
	{
		if(!this.isConnectedTo(aSuspect))
			this.partners.add(aSuspect);
	}
	
	//Returns true if 2 suspects are partners and false if they aren't
	public boolean isConnectedTo(Suspect aSuspect)
	{
		if(this.partners.contains(aSuspect))
			return true;
		return false;
	}
	
	//Returns a array list o suspects that they are partners with the suspect "aSuspect"
	public ArrayList<Suspect> getCommonPartners(Suspect aSuspect)
	{
		ArrayList<Suspect> commonPartners = new ArrayList<>();
		
		for(Suspect aPartner: this.partners)
		{
			if(aSuspect.isConnectedTo(aPartner))
				commonPartners.add(aPartner);
		}
		
		return commonPartners;
	}
	
	//Prints info about suspect's partners
	public void printPartners()
	{
		System.out.println("Partners of " + this.getName() );
		for(Suspect aPartner: partners)
		{
			System.out.print("Name: " + aPartner.getName() + " CodeName: " + aPartner.getCodeName());
			if(this.country.equals(aPartner.country))
					System.out.print("*");
			System.out.println("");
		}
	}
	
	//Returns true if this number belongs to this suspect
	public boolean has(String number)
	{
		if(this.phones.contains(number))
			return true;
		return false;
	}
	
	//Returns the number of suspect's partners
	public int getPartnersNum()
	{
		return this.partners.size();
	}	
}
