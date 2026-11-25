import {add,subtract,multiply} from './math.js'

describe("Math Utility Testing", () => {
    test('should add two numbers', () => {
        expect(add(2, 3)).toBe(5);
    });

    test('should subtract two numbers', () => {
        expect(subtract(5, 3)).toBe(2);
    });
    test('should multiply two numbers', () => {
        expect(multiply(2, 3)).toBe(6);
    });     
});