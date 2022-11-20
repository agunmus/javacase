import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Command {

    ADD_PRODUCT("add product (" + Command.PRICE_RATE_PATTERN + ");(" + Command.PRICE_RATE_PATTERN + ");("
            + Command.QUANTITY_PATTERN + ");(" + Command.STRING_PATTERN + ")" ) {
        @Override
        public void execute(MatchResult matcher, PatikaStore PatikaStore) throws PatikaException {
            if (!(Command.currentProduct == null)) {
                throw new PatikaException("Please select the product type first!");
            }
            double price = Double.parseDouble(matcher.group(1));
            double discountRate = Double.parseDouble(matcher.group(2));
            int quantity = Integer.parseInt(matcher.group(3));
            String productName = matcher.group(4);

            Command.currentProduct = new Product(Command.productId, price, discountRate, quantity, productName);
        }
    },

    ADD_MOBILE_PHONE("add mobile phone (" + Command.STRING_PATTERN + ");(" + Command.STRING_PATTERN + ");("
            + Command.STRING_PATTERN + ")") {
        @Override
        public void execute(MatchResult matcher, PatikaStore patikaStore) throws PatikaException {
            if (Command.currentProduct == null) {
                throw new PatikaException("Please enter the default product specifications first!");
            }
            String brand = matcher.group(1);
            String storage = matcher.group(2);
            String color = matcher.group(3);

            final Product currentProduct = Command.currentProduct;
            MobilePhone mobilePhone = new MobilePhone(currentProduct.getId(), currentProduct.getPrice(),
                    currentProduct.getDiscountRate(), currentProduct.getQuantity(), currentProduct.getName(),
                    patikaStore.getBrandByName(brand), storage, color);

            patikaStore.addProduct(mobilePhone);

            Command.currentProduct = null;
            Command.productId++;
        }
    },

    ADD_NOTEBOOK("add notebook (" + Command.STRING_PATTERN + ")") {
        @Override
        public void execute(MatchResult matcher, PatikaStore patikaStore) throws PatikaException {
            if (Command.currentProduct == null) {
                throw new PatikaException("Please enter the default product specifications first!");
            }
            String brand = matcher.group(1);

            final Product currentProduct = Command.currentProduct;
            Notebook notebook = new Notebook(currentProduct.getId(), currentProduct.getPrice(),
                    currentProduct.getDiscountRate(), currentProduct.getQuantity(), currentProduct.getName(),
                    patikaStore.getBrandByName(brand));

            patikaStore.addProduct(notebook);

            Command.currentProduct = null;
            Command.productId++;
        }
    },

    DELETE_PRODUCT("delete product (" + Command.QUANTITY_PATTERN + ")") {
        @Override
        public void execute(MatchResult matcher, PatikaStore patikaStore) throws PatikaException {
            if (!(Command.currentProduct == null)) {
                throw new PatikaException("Please select the product type first!");
            }
            int productId = Integer.parseInt(matcher.group(1));
            patikaStore.deleteProduct(productId);
        }
    },

    LIST_PRODUCTS("list products") {
        @Override
        public void execute(MatchResult matcher, PatikaStore PatikaStore) throws PatikaException {
            if (!(Command.currentProduct == null)) {
                throw new PatikaException("Please select the product type first!");
            }
        }
    },

    EXIT("exit") {
        @Override
        public void execute(MatchResult matcher, PatikaStore PatikaStore) {
            this.exit();
        }
    };

    private static int productId = 1;
    private static boolean switchSet = true;
    private static Product currentProduct = null;

    private static final String PRICE_RATE_PATTERN = "[0-9]*?(\\.[0-9]{1|2})";
    private static final String STRING_PATTERN = "\\S+";
    private static final String QUANTITY_PATTERN = "\\d+";

    private boolean isRunning;
    private Pattern pattern;

    Command(String pattern) {
        this.isRunning = true;
        this.pattern = Pattern.compile(pattern);
    }

    public static Command executeMatching(String input, PatikaStore patikaStore) throws PatikaException {
        for (Command command : Command.values()) {
            Matcher matcher = command.pattern.matcher(input);
            if (matcher.matches()) {
                command.execute(matcher, patikaStore);
                return command;
            }
        }
        throw new PatikaException("not a valid command!");
    }

    public abstract void execute(MatchResult matcher, PatikaStore patikaStore) throws PatikaException;

    public boolean isRunning() {
        return isRunning;
    }

    protected void exit() {
        isRunning = false;
    }

    public static void setSwitchSet(boolean switchSet) {
        Command.switchSet = switchSet;
    }
}

