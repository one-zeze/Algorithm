import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 파티 수

        boolean[] knowsTruth = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < truthCount; i++) {
            knowsTruth[Integer.parseInt(st.nextToken())] = true;
        }
        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < partySize; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);
        }

        // 진실 전파 과정
        boolean newTruthDiscovered = true;
        while (newTruthDiscovered) {
            newTruthDiscovered = false;
            for (List<Integer> party : parties) {
                boolean partyHasTruthTeller = false;
                for (int person : party) {
                    if (knowsTruth[person]) {
                        partyHasTruthTeller = true;
                        break;
                    }
                }

                if (partyHasTruthTeller) {
                    for (int person : party) {
                        if (!knowsTruth[person]) {
                            knowsTruth[person] = true;
                            newTruthDiscovered = true;
                        }
                    }
                }
            }
        }

        // 과장된 이야기를 할 수 있는 파티 수 계산
        int canLieCount = 0;
        for (List<Integer> party : parties) {
            boolean canLieInParty = true;
            for (int person : party) {
                if (knowsTruth[person]) {
                    canLieInParty = false;
                    break;
                }
            }
            if (canLieInParty) {
                canLieCount++;
            }
        }

        System.out.println(canLieCount);
    }
}
