import{isEligible} from './student';

describe('isEligible', () => {
    test('should return true for attendance >= 75', () => {
        expect(isEligible(80)).toBe(true);
    });
    test('should return false for attendance < 75', () => {
        expect(isEligible(70)).toBe(false);
    });
    test('should throw an error for attendance < 0', () => {
        expect(() => isEligible(-10)).toThrow("Attendance should be between 0 and 100");
    });
    test('should throw an error for attendance > 100', () => {
        expect(() => isEligible(110)).toThrow("Attendance should be between 0 and 100");
    });
});