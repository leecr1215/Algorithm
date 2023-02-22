import java.util.Scanner;

public class Solution_1873_상호의배틀필드 {
	// Up Down Left Right Shoot

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();

			char[][] map = new char[H][W];
			Tank tank = null;
			
			/* map 초기화 및 시작점 찾기 */
			for (int i = 0; i < H; i++) {
				String temp = sc.next();
				for (int j = 0; j < W; j++) {
					char c = temp.charAt(j);
					map[i][j] = c;
					
					if (c == '^') {
						tank = new Tank(i, j, 'U');
						map[i][j] =  '.';
					} else if (c == 'v') {
						tank = new Tank(i, j, 'D');
						map[i][j] =  '.';
					} else if (c == '<') {
						tank = new Tank(i, j, 'L');
						map[i][j] =  '.';
					} else if (c == '>') {
						tank = new Tank(i, j, 'R');
						map[i][j] =  '.';
					}
				}
			}

			int N = sc.nextInt(); // 사용자가 넣을 입력의 개수
			String nStr = sc.next();

			/* 동작 시작 */
			for (int i = 0; i < nStr.length(); i++) {
				char action = nStr.charAt(i);

				if (action == 'U') {
					tank.dir = 'U';
					// 한 칸 위가 경계를 벗어나지 않고
					// 한 칸 위가 평지일 때
					if (tank.x - 1 >= 0 && map[tank.x - 1][tank.y] == '.') {
						tank.x = tank.x - 1;
					}
				} else if (action == 'D') {
					tank.dir = 'D';
					// 한 칸 아래가 경계를 벗어나지 않고
					// 한 칸 아래가 평지일 때
					if(tank.x + 1 < H && map[tank.x + 1][tank.y] == '.') {
						tank.x = tank.x + 1;
					}
				} else if(action == 'L') {
					tank.dir = 'L';
					if(tank.y -1 >= 0 && map[tank.x][tank.y - 1] == '.') {
						tank.y = tank.y - 1;
					}
				} else if(action == 'R') {
					tank.dir = 'R';
					if(tank.y + 1 < W && map[tank.x][tank.y + 1] == '.') {
						tank.y = tank.y + 1;
					}
				}else if(action == 'S') {
					// 포탄 발사
					if(tank.dir == 'U') {
						for(int j = tank.x; j >= 0; j--) {
							if(map[j][tank.y] == '*') {
								// 벽돌로 만들어진 벽이면?
								map[j][tank.y] = '.';
								break;
							}else if(map[j][tank.y] == '#') {
								break;
							}
						}
					}else if(tank.dir == 'D') {
						for(int j = tank.x; j < H; j++) {
							if(map[j][tank.y] == '*') {
								// 벽돌로 만들어진 벽이면?
								map[j][tank.y] = '.';
								break;
							}else if(map[j][tank.y] == '#') {
								break;
							}
						}
					}else if(tank.dir == 'L') {
						for(int j = tank.y; j >= 0; j--) {
							if(map[tank.x][j] == '*') {
								// 벽돌로 만들어진 벽이면?
								map[tank.x][j] = '.';
								break;
							}else if(map[tank.x][j] == '#') {
								break;
							}
						}
					}else if(tank.dir == 'R') {
						for(int j = tank.y; j < W; j++) {
							if(map[tank.x][j] == '*') {
								// 벽돌로 만들어진 벽이면?
								map[tank.x][j] = '.';
								break;
							}else if(map[tank.x][j] == '#') {
								break;
							}
						}
					}
				}

			}
			// 최종적으로 탱크가 있는 위치에는 전차가 바라보는 방향을 나타내자
			if(tank.dir == 'U') {
				map[tank.x][tank.y] = '^';
			}else if(tank.dir == 'D') {
				map[tank.x][tank.y] = 'v';
			}else if(tank.dir == 'L') {
				map[tank.x][tank.y] = '<';
			}else if(tank.dir == 'R') {
				map[tank.x][tank.y] = '>';
			}
			
			
			System.out.print("#"+t + " ");
			
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}
}

class Tank {
	int x;
	int y;
	char dir; // 전차가 바라보는 방향

	public Tank(int x, int y, char dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}
