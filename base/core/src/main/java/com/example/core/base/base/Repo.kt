package com.example.core.base.base

import com.example.core.base.error.DefaultErrorFactory
import com.example.core.base.error.ErrorFactory

abstract class Repo(val errorFactory: ErrorFactory = DefaultErrorFactory())