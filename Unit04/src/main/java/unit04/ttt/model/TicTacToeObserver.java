package unit04.ttt.model;

public interface TicTacToeObserver {
    public void boardChanged(int row, int col);
}

// you interface with 
// see the view
// the view and controler are both part of the GUI(button = view and controller)
// conrtoller updates the model with setOnAction--> tell the model when something changes
// model updates the view sometimes the controller..this is called observer pattern