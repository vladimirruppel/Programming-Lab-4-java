public class AuditionsNumber {
    int count = 0;

    int getCount() {
        return count;
    }

    void setCount(int count) {
        this.count = count;
    }

    int addCount(int plusCount) {
        count += plusCount;
        return count;
    }
}
