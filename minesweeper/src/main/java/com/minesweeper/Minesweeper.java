package com.minesweeper;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Minesweeper {

    private static class MineTile extends JButton {

        int row, col;
        boolean hasMine = false;

        public MineTile(int row, int col) {
            this.row = row;
            this.col = col;
            initialize();
        }

        private void initialize() {
            setFocusable(false);
            setMargin(new Insets(0, 0, 0, 0));
            setFont(new Font("Arial", Font.PLAIN, 30));
            setText(""); // Pas de mine affichée par défaut
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    revealTile();
                }
            });
        }

        public void revealTile() {
            setEnabled(false);
            if (hasMine) {
                setText("💣");
                setBackground(Color.RED);
            } else {
                setText("");
                setBackground(Color.LIGHT_GRAY);
            }
        }
    }

    // Constants
    private final int TILE_SIZE = 70;
    private final int NUM_ROWS = 10;
    private final int NUM_COLUMNS = 10;
    private final int BORDER_WIDTH = NUM_COLUMNS * TILE_SIZE;
    private final int BORDER_HEIGHT = NUM_ROWS * TILE_SIZE + 100; // Inclure la hauteur du label

    // Frame variables
    private final JFrame frame = new JFrame("Minesweeper");
    private final JLabel textLabel = new JLabel("Welcome to Minesweeper!", JLabel.CENTER);
    private final JPanel textPanel = new JPanel();
    private final JPanel boardPanel = new JPanel();
    private final MineTile[][] board = new MineTile[NUM_ROWS][NUM_COLUMNS];
    private final ArrayList<MineTile> mines = new ArrayList<>();

    public Minesweeper() {
        initializeFrame();
        initializeBoard();
        frame.setVisible(true);
    }

    private void initializeFrame() {
        frame.setSize(BORDER_WIDTH, BORDER_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Arial", Font.BOLD, 25));
        textLabel.setOpaque(true);
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel, BorderLayout.CENTER);
        frame.add(textPanel, BorderLayout.NORTH);
    }

    private void initializeBoard() {
        boardPanel.setLayout(new GridLayout(NUM_ROWS, NUM_COLUMNS));
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                MineTile tile = new MineTile(r, c);
                board[r][c] = tile;
                tile.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        MineTile tile = (MineTile) e.getSource();

                        if (e.getButton() == MouseEvent.BUTTON1) {
                            if (tile.getText().equals("")) {
                                if (mines.contains(tile)) {
                                    revealMines();
                                } else {
                                    checkMine(tile.row, tile.col);
                                }
                            }
                        } else if (e.getButton() == MouseEvent.BUTTON3) {
                            if (tile.getText().equals("")) {
                                tile.setText("🚩");
                            } else {
                                tile.setText("");
                            }
                        }
                    }
                });
                boardPanel.add(tile);
            }
        }
        frame.add(boardPanel, BorderLayout.CENTER);

        // Placer les mines
        setMines();
    }

    private void setMines() {
        for (int i = 0; i < 10; i++) {
            int row = (int) (Math.random() * NUM_ROWS);
            int col = (int) (Math.random() * NUM_COLUMNS);
            MineTile tile = board[row][col];
            if (tile.hasMine) {
                i--;
            } else {
                tile.hasMine = true;
                mines.add(tile);
            }
        }
    }

    private void revealMines() {
        for (int i = 0; i < mines.size(); i++) {
            MineTile tile = mines.get(i);
            tile.setText("💣");
        }
    }

    private void checkMine(int row, int col) {
        if (row < 0 || row >= NUM_ROWS || col < 0 || col >= NUM_COLUMNS) {
            return;
        }

        MineTile tile = board[row][col];
        if (!tile.isEnabled()) {
            return;
        }
        tile.setEnabled(false);

        int minesFound = 0;

        // Top
        minesFound += counterMine(row - 1, col - 1); // Haut gauche
        minesFound += counterMine(row - 1, col);     // Haut
        minesFound += counterMine(row - 1, col + 1); // Haut droite

        // Left and Right
        minesFound += counterMine(row, col - 1);     // left
        minesFound += counterMine(row, col + 1);     // right

        // Bottom
        minesFound += counterMine(row + 1, col - 1); // Bas gauche
        minesFound += counterMine(row + 1, col);     // Bas
        minesFound += counterMine(row + 1, col + 1); // Bas droite

        if (minesFound > 0) {
            tile.setText(Integer.toString(minesFound));
        } else {
            tile.setText("");

            // Top
            checkMine(row - 1, col - 1); // Haut gauche
            checkMine(row - 1, col);     // Haut
            checkMine(row - 1, col + 1); // Haut droite

            // Left and Right
            checkMine(row, col - 1);     // left
            checkMine(row, col + 1);     // right

            // Bottom
            checkMine(row + 1, col - 1); // Bas gauche
            checkMine(row + 1, col);     // Bas
            checkMine(row + 1, col + 1); // Bas droite
        }

    }

    private int counterMine(int row, int col) {
        if (row < 0 || row >= NUM_ROWS || col < 0 || col >= NUM_COLUMNS) {
            return 0;
        }
        if (mines.contains(board[row][col])) {
            return 1;
        }
        return 0;
    }
}
