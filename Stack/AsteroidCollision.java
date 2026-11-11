package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {

    /**
     * LeetCode #735 - Asteroid Collision
     *
     * Given an array of integers representing asteroids in a row, find out the state
     * of the asteroids after all collisions.
     *
     * Positive asteroids move to the right, negative asteroids move to the left.
     * Collisions only happen when a right-moving asteroid meets a left-moving asteroid.
     *
     * Time Complexity: O(N) where N is the number of asteroids. Each asteroid is pushed and popped at most once.
     * Space Complexity: O(N) for the stack.
     */
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return new int[0];
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int ast : asteroids) {
            boolean alive = true;

            // Collision condition: asteroid moving left meets top of stack moving right
            while (alive && ast < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int top = stack.peek();
                if (top < -ast) {
                    // Top asteroid explodes, current asteroid continues
                    stack.pop();
                } else if (top == -ast) {
                    // Both asteroids destroy each other
                    stack.pop();
                    alive = false;
                } else {
                    // Current asteroid explodes, top asteroid survives
                    alive = false;
                }
            }

            if (alive) {
                stack.push(ast);
            }
        }

        // Reconstruct remaining asteroids in left-to-right order
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
