package metridoc.grails.card

class CardSwipeEvent {

	static belongsTo = [
      swipeLocation: SwipeLocation,
      swipeType: SwipeType]

    Boolean valid
    Date date
    String time
	
    static constraints = {
    }
}
