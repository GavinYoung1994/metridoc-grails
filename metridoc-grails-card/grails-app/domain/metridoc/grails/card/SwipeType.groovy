package metridoc.grails.card

class SwipeType {

    static hasMany = [cardSwipeEvent: CardSwipeEvent]

    String type

    static constraints = {
    	type(nullable: false)
    }
}
