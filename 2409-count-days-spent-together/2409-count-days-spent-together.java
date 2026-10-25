class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int a1 = convert(arriveAlice);
        int a2 = convert(leaveAlice);
        int b1 = convert(arriveBob);
        int b2 = convert(leaveBob);

        int end = Math.min(a2,b2);
        int start = Math.max(a1,b1);

        return Math.max(0,end-start+1);
    }

    int convert(String s){
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month = Integer.parseInt(s.substring(0,2));
        int day = Integer.parseInt(s.substring(3,5));

        for(int i=0;i<month-1;i++){
            day += days[i];
        }
        return day;
    }
}