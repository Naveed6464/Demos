/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.reflections.demo;

/**
 *
 * @author nmrehman
 */
public class BeforeCommitTest {

    @BeforeCommit
    public void beforeCommit(Entity e) {

    }

    @BeforeCommit
    public void beforeCommit4(int e) {
        
    }

    @BeforeCommit
    public void beforeCommit2(String e) {

    }
}