package metridoc.grails.card

class SwipeLocation {

    static hasMany = [cardSwipeEvent: CardSwipeEvent]

	String location

    static constraints = {
    	location(nullable: false)
    }
}
