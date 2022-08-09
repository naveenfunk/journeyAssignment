package com.journeyassignment.data.mappers

import com.journeyassignment.R
import com.journeyassignment.misc.NETWORK_ERROR
import com.journeyassignment.misc.NO_NETWORK_AVAILABLE
import com.journeyassignment.misc.SOMETHING_WENT_WRONG

val errorsMap = mapOf(
    NO_NETWORK_AVAILABLE to R.string.no_internet_available,
    SOMETHING_WENT_WRONG to R.string.something_went_wrong,
    NETWORK_ERROR to R.string.network_error,
)

fun mapError(errorId: Int) = errorsMap[errorId] ?: R.string.something_went_wrong