module CoffeeMachine {
    requires logger;
    requires java.logging;
    requires java.desktop;
    
    exports coffeetype;
    exports Main;
    exports exceptions;
    exports internationalization;
    exports menu;
}