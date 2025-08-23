import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String defangIPaddr(String address) {
        // split and join with "[.]" inserts the defang sequence between octets
        return Arrays.stream(address.split("\\.", -1))
                     .collect(Collectors.joining("[.]"));
    }
}
