Decorators (Object)
==================

Wand has language support for the decorator design pattern, which allows a transparent layer to be placed between the class implementing an interface and the user of the interface. Because Wand supports this natively in the language syntax, a decorator can be applied to (and removed from) an instance at runtime, and all references to that instance will immediately use the appropriately decorated methods when they are next called.

	public interface Ship {
		public int getDefenceValue( );
		public String getShipName( );
	}
	
	public class SimpleShip implements Ship {
		public int getDefenceValue( ) {
			return 40;
		}
		
		public String getShipName( ) {
			return "Simple Ship";
		}
	}
	
	public decorator DefenceShield decorates Ship {
		private int shieldAmount;
		
		public this( int shieldAmount ) {
			this.shieldAmount = shieldAmount;
		}
	
		public int getDefenceValue( ) {
			return super.getDefenceValue( ) + shieldAmount;
		}
		
		// getShipName gets default pass-through function
	}
	
	int main( ) {
		
		Ship ship = new Ship( );
		
		Console.println( "Defence value: ", ship.getDefenceValue( ) ); // 40
		
		DefenceShield shield = new DefenceShield( 2 );
		shield.decorate( ship );
		
		Console.println( "Defence value: ", ship.getDefenceValue( ) ); // 42
		
		DefenceShield missileDefence = new DefenceShield( 10 );
		decorate ship with missileDefence; // NOTE: draft syntax only
		
		// decorating with missileDefence or ship would now cause an error,
		// only 1 class instance can be decorated with 1 decorator instance
		
		Console.println( "Defence value: ", ship.getDefenceValue( ) ); // 52
		
		strip shield from ship; // NOTE: draft syntax only
		
		Console.println( "Defence value: ", ship.getDefenceValue( ) ); // 50
		
		strip missileDefence from ship; // NOTE: draft syntax only
		
		return 0;
	}