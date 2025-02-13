
class Circular {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int total_surplus = 0, curr_surplus = 0, start = 0;

        for (int i = 0; i < petrol.length; i++) {
            int net_gain = petrol[i] - distance[i];
            total_surplus += net_gain;
            curr_surplus += net_gain;

            if (curr_surplus < 0) {
                start = i + 1;
                curr_surplus = 0;
            }
        }

        return (total_surplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int result = findStartingPoint(petrol, distance);
        System.out.println("Starting Petrol Pump Index: " + result);
    }
}


