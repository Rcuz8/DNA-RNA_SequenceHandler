public class Printable<E> {

    /** Convenience method that prints input
     *
     * @param e input to be printed
     */
    public void pr(E e) {
        System.out.print(e);
    }

    /** Convenience method that prints input
     *
     * @param s input to be printed
     */
    public void pr(String s) {
        System.out.print(s);
    }

    /** Convenience method that prints input
     *
     * @param i input to be printed
     */
    public void pr(int i) {
        System.out.print(i);
    }

    /** Convenience method that prints input
     *
     * @param e input to be printed
     */
    public <E> void prl(E e) {
        System.out.println(e);
    }

    /** Convenience method that prints input
     *
     * @param s input to be printed
     */
    public void prl(String s) {
        System.out.println(s);
    }

    /** Convenience method that prints input
     *
     * @param i input to be printed
     */
    public void prl(int i) {
        System.out.println(i);
    }
}
