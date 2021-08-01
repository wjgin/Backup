package programmers;

// 순위를 구하는 알고리즘 
// 플로이드 워셜 알고리즘

/* 플로이드 워셜
 *  i -> j, j -> k => i -> k
 *  총 n명의 선수가 있을 때, 선수가 n-1의 경기를 했다면(승리했거나 패배했거나) 순위를 확인할 수 있음
 * */
class Ranking {
    public int solution(int n, int[][] results) {
        int answer = 0;
       // [n][n] 배열
        boolean[][] gameResult = new boolean[n][n];
        
        // 경기 결과 대입(a선수가 b선수에게 이기면 [a-1][b-1] = true;
        for(int i = 0; i < results.length; i++) {
        		gameResult[results[i][0]-1][results[i][1]-1] = true;
        } // i for end
        
        // i -> j, j -> k => i -> k
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		for(int k = 0; k < n; k++) {
        			if(gameResult[i][j] && gameResult[j][k]) gameResult[i][k] = true;
        		} // for k end
        	} // for j end
        } // for i end
        		
        // 선수가 n-1의 경기를 했다면(승리했거나 패배했거나) 순위를 확인할 수 있음 answer++
        for(int i = 0; i < n; i++) {
        	int cnt = 0;	// 경기 횟수 카운트
        	for(int j = 0; j < n; j++) {
        		if(gameResult[i][j] || gameResult[j][i]) cnt++;	// 선수가 승리했거나 패했다면 경기 횟수 ++ 
        	} // for j end
        	if(cnt == n-1) answer++;	// 경기 횟수가 n-1이라면 그 선수의 순위를 알 수 있다. answer++
        } // for i end
        
        return answer;
    } // sol end
}


