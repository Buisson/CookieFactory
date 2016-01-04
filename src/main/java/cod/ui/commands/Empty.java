package cod.ui.commands;

import java.util.List;

import cod.CookieOnDemand;
import cod.ShoppingCart;
import cod.tcf.Customer;
import cod.tcf.Item;
import cod.tcf.Recipes;
import cod.ui.framework.Command;

public class Empty extends Command<CookieOnDemand> {

	protected Customer customer;
	
	@Override
	public String identifier() {return "empty";}

	
	@Override
	public void load(List<String> args) {
		customer = system.getCustomers().findByFirstName(args.get(0)).get();
	}
	
	@Override
	public void execute() {
		ShoppingCart cart = system.getShoppingCart(customer);
		for(Item i : cart.contents()){
			cart.remove(i);
		}
	}

	@Override
	public String describe() {
		return "delete all items in the cart (empty CUSTOMER)";
	}

	/*


	*/

}
