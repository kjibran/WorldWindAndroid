/*
 * Copyright (c) 2016 United States Government as represented by the Administrator of the
 * National Aeronautics and Space Administration. All Rights Reserved.
 */

package gov.nasa.worldwind;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import gov.nasa.worldwind.util.MessageService;
import gov.nasa.worldwind.util.TaskService;

public class WorldWind {

    /**
     * Altitude mode constant indicating an altitude relative to the globe's ellipsoid. Ignores the elevation of the
     * terrain directly beneath the position's latitude and longitude.
     */
    public static final int ABSOLUTE = 0;

    /**
     * The BEGAN gesture recognizer state. Continuous gesture recognizers transition to this state from the POSSIBLE
     * state when the gesture is first recognized.
     */
    public static final int BEGAN = 3;

    /**
     * The CANCELLED gesture recognizer state. Continuous gesture recognizers may transition to this state from the
     * BEGAN state or the CHANGED state when the touch events are cancelled.
     */
    public static final int CANCELLED = 5;

    /**
     * The CHANGED gesture recognizer state. Continuous gesture recognizers transition to this state from the BEGAN
     * state or the CHANGED state, whenever an input event indicates a change in the gesture.
     */
    public static final int CHANGED = 4;

    /**
     * Altitude mode constant indicating an altitude on the terrain. Ignores a position's specified altitude, and always
     * places the position on the terrain.
     */
    public static final int CLAMP_TO_GROUND = 1;

    /**
     * Altitude mode constant indicating an altitude relative to the terrain. The altitude indicates height above the
     * terrain directly beneath the position's latitude and longitude.
     */
    public static final int RELATIVE_TO_GROUND = 2;

    /**
     * Notification constant requesting that World Window instances render a frame.
     */
    public static final String REQUEST_RENDER = "gov.nasa.worldwind.RequestRender";

    /**
     * The ENDED gesture recognizer state. Continuous gesture recognizers transition to this state from either the BEGAN
     * state or the CHANGED state when the current input no longer represents the gesture.
     */
    public static final int ENDED = 6;

    /**
     * The FAILED gesture recognizer state. Gesture recognizers transition to this state from the POSSIBLE state when
     * the gesture cannot be recognized given the current input.
     */
    public static final int FAILED = 1;

    /**
     * Path type constant indicating a great circle arc between two locations.
     */
    public static final int GREAT_CIRCLE = 0;

    /**
     * Path type constant indicating simple linear interpolation between two locations.
     */
    public static final int LINEAR = 1;

    /**
     * The POSSIBLE gesture recognizer state. Gesture recognizers in this state are idle when there is no input event to
     * evaluate, or are evaluating input events to determine whether or not to transition into another state.
     */
    public static final int POSSIBLE = 0;

    /**
     * The RECOGNIZED gesture recognizer state. Discrete gesture recognizers transition to this state from the POSSIBLE
     * state when the gesture is recognized.
     */
    public static final int RECOGNIZED = 2;

    /**
     * Path type constant indicating a line of constant bearing between two locations.
     */
    public static final int RHUMB_LINE = 2;

    /**
     * Provides a global mechanism for broadcasting notifications within the World Wind library and Wordl Wind
     * applications.
     */
    protected static MessageService messageService = new MessageService();

    /**
     * Provides a global service for exeuting asynchronous tasks within the World Wind library and Wordl Wind
     * applications.
     */
    protected static TaskService taskService = new TaskService();

    /**
     * Returns a MessageService that provides a mechanism for broadcasting notifications within a World Wind
     * application.
     *
     * @return the default message center
     */
    public static MessageService messageService() {
        return messageService;
    }

    /**
     * Returns an Executor that runs tasks on a non-UI/non-GL thread.
     *
     * @return an Executor for running asynchronous tasks
     */
    public static TaskService taskService() {
        return taskService;
    }

    /**
     * Requests that all World Window instances render a frame. Internally, this dispaches a REQUEST_RENDER message to
     * the World Wind message center.
     */
    public static void requestRender() {
        messageService.postMessage(REQUEST_RENDER, null, null); // specify null for no sender, no user properties
    }

    /**
     * Altitude mode indicates how World Wind interprets a position's altitude component. Accepted values are {@link
     * #ABSOLUTE}, {@link #CLAMP_TO_GROUND} and {@link #RELATIVE_TO_GROUND}.
     */
    @IntDef({ABSOLUTE, CLAMP_TO_GROUND, RELATIVE_TO_GROUND})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AltitudeMode {

    }

    /**
     * Path type indicates how World Wind create a geographic path between two locations. Accepted values are {@link
     * #GREAT_CIRCLE}, {@link #LINEAR} and {@link #RHUMB_LINE}.
     */
    @IntDef({GREAT_CIRCLE, LINEAR, RHUMB_LINE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PathType {

    }

    /**
     * Gesture state indicates a GestureRecognizer's current state. Accepted values are {@link #POSSIBLE}, {@link
     * #FAILED}, {@link #RECOGNIZED}, {@link #BEGAN}, {@link #CHANGED}, {@link #CANCELLED}, and {@link #ENDED}.
     */
    @IntDef({POSSIBLE, FAILED, RECOGNIZED, BEGAN, CHANGED, CANCELLED, ENDED})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GestureState {

    }
}
