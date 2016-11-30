package com.davidmiguel.gobees.hive;

import android.support.annotation.NonNull;

import com.davidmiguel.gobees.data.model.Recording;
import com.davidmiguel.gobees.utils.BasePresenter;
import com.davidmiguel.gobees.utils.BaseView;

import java.util.Date;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface HiveContract {

    interface View extends BaseView<HiveContract.Presenter> {

        /**
         * Displays or hide loading indicator.
         *
         * @param active true or false.
         */
        void setLoadingIndicator(final boolean active);

        /**
         * Shows list of recordings.
         *
         * @param recordings recordings to show (list cannot be empty).
         */
        void showRecordings(@NonNull List<Recording> recordings);

        /**
         * Opens activity to record a hive.
         */
        void startNewRecording();

        /**
         * Opens activity to show the details of the given recording.
         *
         * @param date recording date.
         */
        void showRecordingDetail(Date date);

        /**
         * Shows loading recordings error message.
         */
        void showLoadingRecordingsError();

        /**
         * Makes visible the no recordings view.
         */
        void showNoRecordings();

        /**
         * Shows successfully saved message.
         */
        void showSuccessfullySavedMessage();

        /**
         * Sets the title in the action bar.
         *
         * @param title title.
         */
        void showTitle(@NonNull String title);
    }

    interface Presenter extends BasePresenter {

        /**
         * Shows a snackbar showing whether a hive was successfully added or not.
         *
         * @param requestCode request code from the intent.
         * @param resultCode  result code from the intent.
         */
        void result(int requestCode, int resultCode);

        /**
         * Load recordings from repository.
         *
         * @param forceUpdate force cache update.
         */
        void loadRecordings(boolean forceUpdate);

        /**
         * Orders to open activity to record a hive.
         */
        void startNewRecording();

        /**
         * Opens activity to show the details of the given hive.
         *
         * @param date recording date.
         */
        void openRecordingsDetail(@NonNull Date date);
    }
}
