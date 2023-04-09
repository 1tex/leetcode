def max_taste(n, taste_values):
    """
    计算小美能获得的糖果美味值之和的最大值。
    :param n: 糖果数量
    :param taste_values: 糖果美味值列表
    :return: 最大的糖果美味值之和
    """
    if n == 1:
        return taste_values[0]

    dp = [0] * n
    dp[0] = taste_values[0]
    dp[1] = max(taste_values[0], taste_values[1])

    for i in range(2, n):
        dp[i] = max(dp[i - 1], dp[i - 2] + taste_values[i])

    return dp[-1]

def main():
    n = int(input())
    taste_values = list(map(int, input().split()))

    max_taste_sum = max_taste(n, taste_values)
    print(max_taste_sum)

if __name__ == "__main__":
    main()
